package app.asset;
import java.io.*;

public class AssetNote extends DashboardAsset implements Serializable{
    private String noteText;

    public AssetNote(int id, String name) {
	super(id, name);
	noteText = new String("new note");
    }
    
    public void setContents(String contents){
        this.noteText = contents;
    }

    public String getContents(){
        return this.noteText;
    }

    @Override
    public String display(){
	String retStr = "";
	// display title/name
	retStr += "<b>" + getName() + "</b>";
	// display note contents
	retStr += "<p>" + noteText + "</p>";

	// option to edit note
	retStr += "<form action='editnote' method='post'>";
	retStr += "<input type='hidden' name='id' value='" + getId() + "'>";
	retStr += "<input type='submit' name='submit' value='edit'><br>";
	retStr += "</form>";
	return retStr;
    }
}
