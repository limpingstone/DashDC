package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.io.*;

@SpringBootApplication
@RestController
public class Application {


    private static Dashboard dashboard;
    private static Page currentPage; // current page the viewer is seeing
    // may be unnecessary
    private static Tile currentTile;

    private static DashboardAsset currentAsset;

    private static final String[] ASSET_TYPES = new String[]{"image", "note", "list"};
    
    @RequestMapping("/")
    public String dash() {
	String retStr = "<h1>User Dashboard</h1>";
	retStr = "Here are the pages that currently exist. Select one: <br>";
	retStr += "<form action='page' method='post'>";
	retStr += "<select name='id'>"; // page id
	List<Page> pages = dashboard.getPages();
	for ( int i = 0; i < pages.size(); i++ ) 
	    retStr += "<option value='" + pages.get(i).getId() + "'>" + pages.get(i).getName() + "</option>";
	retStr += "</select>";
	retStr += "<input type='submit' name='submit'>";
	retStr += "</form><br>";
	    
	retStr += "<br> Add a new page.<br>";
	retStr += "<form action='newpage' method='post'>";
	retStr += "Name: <input type='text' name='name'> <br>";
	retStr += "ID: <input type='number' name='id'> <br>";
	retStr += "<input type='submit' name='submit'> <br>";
	retStr += "</form>";

	retStr += "<form action='save' method='post'>";
	retStr += "<input type='submit' name='Save Dashboard'> <br>";
	retStr += "</form> <br>";
	    
	int[] assetSize = {400,400};
	int[] assetPosition = new int[2];
	AssetImage cat = new AssetImage(900, "default", "https://upload.wikimedia.org/wikipedia/commons/e/eb/Ash_Tree_-_geograph.org.uk_-_590710.jpg", assetSize, assetPosition);
	retStr += cat.display();
	
	return retStr;
	    
    }

    @RequestMapping("/newpage")
    public String newPage(@ModelAttribute FormCapture form) {
        dashboard.addPage(form.getId(), form.getName());
        return dash();
    }

    @RequestMapping("/page")
    public String pageOptions(@ModelAttribute FormCapture form) {
        currentPage = dashboard.getDashboardPage(form.getId());
        return pageOptions();
    }

    public String pageOptions() {
	String retStr = "";

	retStr += "You are viewinzg page: " + currentPage.getName() + "<br>";
	List<Tile> tiles = currentPage.getTiles();
	/* move this to Page.java */
	for ( int i = 0; i < tiles.size(); i++ ) {
	    retStr += tiles.get(i).getName() + "<br>";
	    retStr += tiles.get(i).display();
	}
	retStr += "<br>";

	retStr += "<br> Tile options.<br>";
	retStr += "<form action='tile' method='post'>";
	retStr += "<select name='id'>"; // tile id

	for ( int i = 0; i < tiles.size(); i++ ) 
	    retStr += "<option value='" + tiles.get(i).getId() + "'>" + tiles.get(i).getName() + "</option>";
	retStr += "</select>";
	retStr += "<input type='submit' name='submit'>";
	retStr += "</form><br>";


	retStr += "<br> Add a new tile.<br>";
	retStr += "<form action='newtile' method='post'>";
	retStr += "Name: <input type='text' name='name'> <br>";
	retStr += "ID: <input type='number' name='id'> <br>";
	retStr += "<input type='submit' name='submit'> <br>";
	retStr += "</form>";

	return retStr;
    }

    @RequestMapping("/tile")
    public String tileOptions(@ModelAttribute FormCapture form) {
	currentTile = currentPage.getTile(form.getId());
	return tileOptions();
    }

    public String tileOptions() {
	String retStr = "";

	retStr += "You are viewing tile: " + currentTile.getName() + "<br>";
	List<DashboardAsset> assets = currentTile.getAssets();
	for ( int i = 0; i < assets.size(); i++ )
	    retStr += assets.get(i).getName() + "<br>";
	retStr += "<br>";

	retStr += "<br> Add a new asset.<br>";
	retStr += "<form action='newasset' method='post'>";
	retStr += "Name: <input type='text' name='name'> <br>";
	retStr += "ID: <input type='number' name='id'> <br>";
	retStr += "<select name='type'>"; // asset type
	for ( int i = 0; i < ASSET_TYPES.length; i++ ) {
	    retStr += "<option value='" + ASSET_TYPES[i] + "'>" + ASSET_TYPES[i] + "</option>";
	}
	retStr += "</select>";
	retStr += "<input type='submit' name='submit'> <br>";
	retStr += "</form>";

	return retStr;
    }

    
    @RequestMapping("/newtile")
    public String newTile(@ModelAttribute FormCapture form) {
        currentPage.addTile(form.getId(), form.getName());
        return pageOptions();
    }
	    
    @RequestMapping("/newasset")
    public String newAsset(@ModelAttribute FormCapture form) {
	String type = form.getType();
	String retStr = "";
	if ( type.equals("image") ) {
	    retStr += "<form action='newimage' method='post'>";
	    retStr += "Name: <input type='text' name='name'> <br>";
	    retStr += "ID: <input type='number' name='id'> <br>";
	    retStr += "Link to image: <input type='text' name='link'> <br>";
	    retStr += "Size x: <input type='number' name='xsize'> y: <input type='number' name='ysize'> <br>";
	    retStr += "Position x: <input type='number' name='xpos'> y: <input type='number' name='ypos'> <br>";
	    retStr += "<input type='submit' name='submit'> <br>";
	    retStr += "</form>";
	}

	return retStr;
    }

    @RequestMapping("/newimage")
    public String newImage(@ModelAttribute FormCapture form) {
	int[] size = new int[] {form.getXsize(), form.getYsize() };
	int[] position = new int[] {form.getXpos(), form.getYpos() };
	currentTile.addAssetImage(form.getId(), form.getName(), form.getLink(), size, position);
	return tileOptions(); 
    }
    

    // for prototyping only
    public static void setup() {
	// check if save file exists
	File save = new File("src/main/save/dash_save.ser");
	if ( save.exists() )
	    Application.dashboard = load();
	else
	    Application.dashboard = new Dashboard();
    }

    /* move to ByteCode */
    @RequestMapping("/save")
    public static String save() {
	//ByteCode.generateSaveFile(dashboard, "dash_save.ser");
	try {
	    FileOutputStream fileOut = new FileOutputStream("src/main/save/dash_save.ser");
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    out.writeObject(dashboard);
	    out.close();
	    fileOut.close();
	}
	catch (IOException i) {
	    i.printStackTrace();
	}

	return "Your dashboard has been saved.";
    }

    // returns a dashboard object from save file
    public static Dashboard load() {
    	try {
	    FileInputStream fileIn = new FileInputStream("src/main/save/dash_save.ser");
	    ObjectInputStream in = new ObjectInputStream(fileIn);
	    Dashboard d = (Dashboard) in.readObject();
	    in.close();
	    fileIn.close();
	    return d;
	} catch (IOException i) {
	    i.printStackTrace();
	    return null;
	} catch (ClassNotFoundException c) {
	    System.out.println("Employee class not found");
	    c.printStackTrace();
	    return null;
	}
	
    }

    @RequestMapping("/control-panel")
    public String controlPanel(){
        return "<h1>Control panel</h1>";
    }

    @RequestMapping("/customization-tool")
    public String customizationTool(){
        return "<h1>Customization tool</h1>";
    }

    /*  Launching the application   */

    public static void main(String[] args) {
	Application.setup();
        SpringApplication.run(Application.class, args);
    }
}
