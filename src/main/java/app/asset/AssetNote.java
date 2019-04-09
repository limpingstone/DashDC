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
	// Display title/name
	retStr += "<b>" + getName() + "</b>";
	// Display note contents
	// Replace all \n with <br> to render newlines in HTML properly
	retStr += "<p>" + noteText.replaceAll("\n", "<br>") + "</p>";

	// option to edit note
	retStr += "<form action='editnote' method='post'>";
	retStr += "<input type='hidden' name='id' value='" + getId() + "'>";
	retStr += "<input type='submit' name='submit' value='edit'><br>";
	retStr += "</form>";
	return retStr;
    }
}
