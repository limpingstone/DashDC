package app.asset;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class AssetList extends DashboardAsset implements Serializable {

	private char type; // 'u' for unordered, 'o' for ordered
	private List<String> listContents;

	// Takes an int id, String name, and a char type
	// Constructs asset with specified id and name
	// Sets list type of either ordered or unordered, depending on type parameter
	// type 'u' -> unordered list
	// type 'o' -> ordered list
	public AssetList(int id, String name, char type) {
		super(id, name);
		this.type = type;
		listContents = new ArrayList<String>();
		/*
		 * for prototyping only listContents.add("hello"); listContents.add("calvin");
		 */
	}

	// Returns type attribute
	public char getType() {
		return type;
	}

	// sets the type attribute to parameter
	public void setType(char type) {
		this.type = type;
	}

	// returns the List of string contents
	public List<String> getListContents() {
		return listContents;
	}

	// Adds a new String element to the end of listContents
	// The string is specified by the contents of text
	public void addListItem(String text) {
		listContents.add(text);
	}

	// Adds a new String element to listContents
	// The string is specified by the conetents of text
	// The position of the new element is specified by pos
	public void addListItem(String text, int pos) {
		if (pos >= listContents.size())
			return; // possibly throw an error
		listContents.add(pos, text);
	}

	// Returns the String contents of the list in the following specified format
	// Each element of the list is preceeded by a *.
	// Each element of the list is suceeded by a \n.
	public String contentEdit() {
		String retStr = "";
		for (int i = 0; i < listContents.size(); i++) {
			retStr += "*";
			retStr += listContents.get(i);
			retStr += "\n";
		}
		return retStr;
	}

	// Takes in a String of list contents in the same format produced by
	// contentEdit()
	// Parses input and updates list contents accordingly
	public void updateContents(String newContents) {
		String[] contentArray = newContents.split("\\*");
		// copy array contents into the List data structure
		listContents = new ArrayList<String>(); // clear old contents
		for (int i = 1; i < contentArray.length; i++) // start at 1 to skip empty string
			listContents.add(contentArray[i].replaceAll("\n", ""));

	}

	// Returns the HTML string to display the list contents
	@Override
	public String display() {
		String retStr = getName() + ":";
		// determine bulleted or numbered list
		if (type == 'u')
			retStr += "<ul>";
		else if (type == 'o')
			retStr += "<ol>";
		// HTML for list contents
		for (int i = 0; i < listContents.size(); i++)
			retStr += "<li>" + listContents.get(i) + "</li>";
		// close list
		if (type == 'u')
			retStr += "</ul>";
		else if (type == 'o')
			retStr += "</ol>";

		// option to edit list
		retStr += "<form action='editlist' method='post'>";
		retStr += "<input type='hidden' name='id' value='" + getId() + "'>";
		retStr += "<input type='submit' name='submit' value='edit'><br>";
		retStr += "</form>";

		return retStr;

	}
}
