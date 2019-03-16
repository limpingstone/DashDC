package app;

public class AssetNote extends DashboardAsset{
    private String noteText;

    public AssetNote(int id, String name) {
	super(id, name);
    }
    
    public void setContents(String contents){
        this.noteText = contents;
    }

    public String getContents(){
        return this.noteText;
    }

    @Override
    public String display(){
        return "<p>" + noteText + "</p>";
    }
}
