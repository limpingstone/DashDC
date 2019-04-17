package app;

// A class for capturing and storing data sent via HTML form.
// The form information is stored in the private fields.
// The class must contain getter and setter methods for each field in order for program to read and capture form information.
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

    // Returns the field name
    public String getName() {
        return name;
    }

    // Sets the field name to the input parameter string
    public void setName(String name) {
        this.name = name;
    }

    // Returns the field id
    public int getId() {
        return id;
    }

    // Sets the field id to the input parameter id
    public void setId(int id) {
        this.id = id;
    }

    // Returns the field type
    public String getType() {
        return type;
    }

    // Sets the field type to the input parameter
    public void setType(String type) {
        this.type = type;
    }

    // Returns the field link
    public String getLink() {
        return link;
    }

    // Sets the field link to the input parameter
    public void setLink(String link) {
        this.link = link;
    }

    // Returns the field text
    public String getText() {
	return text;
    }

    // Sets the field text to the input parameter
    public void setText(String text) {
	this.text = text;
    }

    // Returns the field xsize
    public int getXsize() {
        return xsize;
    }

    // Sets the field xsize to the input parameter
    public void setXsize(int xsize) {
        this.xsize = xsize;
    }

    // Returns the field ysize
    public int getYsize() {
        return ysize;
    }

    // Sets the field ysize to the input parameter
    public void setYsize(int ysize) {
        this.ysize = ysize;
    }

    // Returns the field xpos
    public int getXpos() {
        return xpos;
    }

    // Sets the field xpos to the input parameter
    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    // Returns the field ypos
    public int getYpos() {
        return ypos;
    }

    // Sets the field ypos to the input parameter
    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    // Returns the field tileId
    public int getTileId() {
	return tileId;
    }

    // Sets the field tileId to the input parameter
    public void setTileId(int tileId) {
	this.tileId = tileId;
    }

    // Returns the field assetId
    public int getAssetId() {
	return assetId;
    }

    // Sets the field assetId to the input parameter
    public void setAssetId(int assetId) {
	this.assetId = assetId;
    }

}
