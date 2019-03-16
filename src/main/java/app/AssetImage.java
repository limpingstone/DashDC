package app;

public class AssetImage extends DashboardAsset{
    
    //  String to hold image path.
    private String imagePath;

    //  Constructor, takes id, name, path, size and position for the asset
    public AssetImage(int id, String name, String imagePath, int[] size, int[] position){
	super(id, name);
        this.imagePath = imagePath;
        this.size = size;
        this.position = position;
    }
    
    //  Sets the path to the image
    public void setPath(String imagePath){
        this.imagePath = imagePath;
    }

    //  Gets the path for the image
    public String getPath(){
        return imagePath;
    }

    //  Generates the HTML code to display the image
    @Override
    public String display(){
        return "<img src=\"" + imagePath + "\" style=\"width:" + size[0] + "; height: "+ size[1] + ";\">";
    }
}
