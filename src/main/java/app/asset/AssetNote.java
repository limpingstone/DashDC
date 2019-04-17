package app.asset;
import java.io.*;

public class AssetNote extends DashboardAsset implements Serializable{
    // stores the note contents
    private String noteText;

    // Constructor
    // Takes in id and name as parameter inputs
    // Calls the parent constructor on id and name
    // Sets the noteText field to a default string
    public AssetNote(int id, String name) {
	super(id, name);
	noteText = new String("new note");
    }

    // Takes a String contents
    // Sets the noteText attribute to the String contents
    public void setContents(String contents){
        this.noteText = contents;
    }

    // Returns the noteText attribute
    public String getContents(){
        return this.noteText;
    }

    // Returns a String of the HTML to display the AssetNote 
    @Override
    public String display(){
	String retStr = "";
	// Display title/name

	retStr += "<h3>" + getName() + "</h3>";

	// Display note contents
	// Replace all \n with <br> to render newlines in HTML properly
	retStr += "<p class='noteasset'>" + noteText.replaceAll("\n", "<br>") + "</p>";

	// option to edit note
	retStr += "<form action='editnote' method='post'>";
	retStr += "<input type='hidden' name='id' value='" + getId() + "'>";
	retStr += "<input type='submit' name='submit' value='Edit'><br>";
	retStr += "</form>";
	return retStr;
    }
}
