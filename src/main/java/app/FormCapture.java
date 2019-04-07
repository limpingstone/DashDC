package app;

// for capturing and storing data sent via HTML form
// consider creating a unique one for each form in our application
// these classes MUST CONTAIN ACCESSOR AND MUTATOR METHODS in order to capture form info
public class FormCapture {
    private String name;
    private int id;
    private String type;
    private String link;
    private String text;
    private int xsize, ysize;
    private int xpos, ypos;

    private int tileId;
    private int assetId;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }
    
    public int getXsize() {
        return xsize;
    }

    public void setXsize(int xsize) {
        this.xsize = xsize;
    }

    public int getYsize() {
        return ysize;
    }

    public void setYsize(int ysize) {
        this.ysize = ysize;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public int getTileId() {
	return tileId;
    }

    public void setTileId(int tileId) {
	this.tileId = tileId;
    }

    public int getAssetId() {
	return assetId;
    }

    public void setAssetId(int assetId) {
	this.assetId = assetId;
    }

}
