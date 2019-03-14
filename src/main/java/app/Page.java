package app;

import java.util.List;
public class Page {
    String name;
    int id;
    String contents; // prototyping purposes only

    public Page() {
	name = "Default.";
	id = 0;
	contents = "null";
    }

    public Page(int pageID, String pageName) {
	name = pageName;
	id = pageID;
    }

    public void setContents(String textData) {
	contents = textData;
    }

    public String getContents() {
	return contents;
    }

    public String getName() {
	return name;
    }

    public int getId() {
	return id;
    }
    
}
