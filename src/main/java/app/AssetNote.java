package app;

public class AssetNote extends DashboardAsset{
    private String noteText;

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
