package app;

import org.springframework.web.servlet.view.RedirectView; //For Redirectview

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.io.*;
import java.lang.ProcessBuilder.Redirect;
import app.asset.*;
import app.dashboard.*;


@SpringBootApplication
@RestController
public class Application {
	// Temporary public to test dashboard controller (PROTO)
	public static Dashboard dashboard;
	// Stores the current page being viewed (PROTO)
	private static Page currentPage;
	// Stores the current tiles (PROTO)
	private static Tile currentTile;
	// Stores current assets (PROTO)
	private static DashboardAsset currentAsset;

	// Declares the types of assets available
	private static final String[] ASSET_TYPES = new String[] { "image", "note", "list" };

	// Control page address
	@RequestMapping("/page")
	public String pageOptions(@ModelAttribute FormCapture form) {
		currentPage = dashboard.getDashboardPage(form.getId());
		//get display 
		return pageOptions();
	}

	// the controller to handle creating a new page (link here if you want to create a new page)
	@RequestMapping("/newpage")
    public RedirectView newPage(@ModelAttribute FormCapture form) {
        dashboard.addPage(form.getId(), form.getName());
        return new RedirectView("/");
    }

	//returns the display for the page.
	public String pageOptions() {
		//Clear the prototyped display
		String retStr = "";
		//Add the page name to the view
		retStr += "You are viewing page: " + currentPage.getName() + "<br>";

		List<Tile> tiles = currentPage.getTiles();
		/* move this to Page.java */
		for (int i = 0; i < tiles.size(); i++) {
			retStr += tiles.get(i).getName() + "<br>";
			retStr += tiles.get(i).display();
		}

		retStr += "<br><br> Tile options.<br><form action='tile' method='post'><select name='id'>";

		for (int i = 0; i < tiles.size(); i++) {
			retStr += "<option value='" + tiles.get(i).getId() + "'>" + tiles.get(i).getName() + "</option>";
		}

		retStr += "</select><input type='submit' name='submit'></form><br><br> Add a new tile.<br><form action='newtile' method='post'>Name: <input type='text' name='name'> <br>ID: <input type='number' name='id'> <br><input type='submit' name='submit'> <br></form>";

		return retStr;
	}

	//display the page for tiles
	@RequestMapping("/tile")
	public String tileOptions(@ModelAttribute FormCapture form) {
		currentTile = currentPage.getTile(form.getId());
		return tileOptions();
	}

	//Returns the view for tiles
	public String tileOptions() {
		String retStr = "";

		retStr += "You are viewing tile: " + currentTile.getName() + "<br>";

		List<DashboardAsset> assets = currentTile.getAssets();

		for (int i = 0; i < assets.size(); i++){
			retStr += assets.get(i).getName() + "<br>";
		}

		//retStr += "<br><br> Add a new asset.<br><form action='newasset' method='post'>Name: <input type='text' name='name'> <br>ID: <input type='number' name='id'> <br><select name='type'>";
		retStr += "<br><br> Add a new asset.<br><form action='newasset' method='post'><select name='type'>";

		for (int i = 0; i < ASSET_TYPES.length; i++) {
			retStr += "<option value='" + ASSET_TYPES[i] + "'>" + ASSET_TYPES[i] + "</option>";
		}

		retStr += "</select><input type='submit' name='submit'> <br></form>";

		return retStr;
	}

	//Handles the requests for new tile.
	@RequestMapping("/newtile")
	public String newTile(@ModelAttribute FormCapture form) {
		currentPage.addTile(form.getId(), form.getName());
		return pageOptions();
	}

	
	@RequestMapping("/newasset")
	public String newAsset(@ModelAttribute FormCapture form) {
		String type = form.getType();
		String retStr = "";
		if (type.equals("image"))
		    retStr += newImageHTML();
		else if ( type.equals("list") )
		    retStr += newListHTML();
		else if (type.equals("note"))
		    retStr += newNoteHTML();

		return retStr;
	}

    // Returns the HTML string necessary to gather user input in creating a new image asset
    private String newImageHTML() {
	return "<form action='newimage' method='post'>Name: <input type='text' name='name'> <br>ID: <input type='number' name='id'> <br>Link to image: <input type='text' name='link'> <br>Size x: <input type='number' name='xsize'> y: <input type='number' name='ysize'> <br>Position x: <input type='number' name='xpos'> y: <input type='number' name='ypos'> <br><input type='submit' name='submit'> <br></form>";
    }
    
        @RequestMapping("/newimage")
	public String newImage(@ModelAttribute FormCapture form) {
		int[] size = new int[] { form.getXsize(), form.getYsize() };
		int[] position = new int[] { form.getXpos(), form.getYpos() };
		currentTile.addAssetImage(form.getId(), form.getName(), form.getLink(), size, position);
		return tileOptions();
	}

    // Returns the HTML string necessary to gather user input in creating a new list asset
    private String newListHTML() {
	String retStr = "<form action='newlist' method='post'>List Title: <input type='txt' name='name'> <br>ID: <input type='number' name='id'>";
	retStr += "<br>List Type:<br>";
	retStr += "<input type='radio' name='type' value='unordered'>unordered<br>";
	retStr += "<input type='radio' name='type' value='ordered'>ordered<br>";
	retStr += "<input type='submit' name='submit'> <br>";
	retStr += "</form>";
	return retStr;
    }
	    
    @RequestMapping("/newlist")
    public String newList(@ModelAttribute FormCapture form) {
	currentTile.addAssetList(form.getId(), form.getName(), form.getType());
	return tileOptions();
    }

    // Gathers the user input on how to edit list
    @RequestMapping("/editlist")
    public String editList(@ModelAttribute FormCapture form) {
	// find the asset object to edit
	DashboardAsset asset = null;
	Tile tile = null; 
	List<Tile> tiles = currentPage.getTiles();
	for ( int i = 0; i < tiles.size(); i++ ) {
	    tile = tiles.get(i);
	    asset = tile.getAsset(form.getId());
	    if ( asset != null )
		break;
	}
	if ( asset == null || tile == null) // asset not found
	    return "List asset not found.";

	// the AssetList that wants to be edited
	AssetList listAsset = (AssetList) asset;

	String retStr = "<p>Instructions: You can edit the name by changing the textbox. The list contents are in the big text box below. Each list element is delimited by a *. You can add new list elements by adding new * and the list contents. You can delete list elements by removing a * and its contents. You can edit list element content itself by not changing the *.</p>";
	retStr += "<form action='executelistedit' method='post'>";
	retStr += "Name: <input type='text' name='name' value='" + listAsset.getName() + "'><br>";
	retStr += "<input type='hidden' name='tileId' value='" + tile.getId() + "'>";
	retStr += "<input type='hidden' name='assetId' value='" + listAsset.getId() + "'>";
	// type
	if ( listAsset.getType() == 'o' ) {
	    retStr += "<input type='radio' name='type' value='unordered'> unordered <br>";
	    retStr += "<input type='radio' name='type' value='ordered' checked> ordered <br>";
	}
	else { // listAsset.getType() == 'u'
	    retStr += "<input type='radio' name='type' value='unordered' checked> unordered <br>";
	    retStr += "<input type='radio' name='type' value='ordered'> ordered <br>";
	}
	retStr += "Conents: <br> <textarea rows='25' cols='100' name='text'>" + listAsset.contentEdit() + "</textarea> <br>";
	retStr += "<input type='submit' name='submit' value='Confirm edit'>";
	retStr += "</form>";
	
	return retStr;
    }

    // Edits the AssetList object based on user input received through /editlist
    @RequestMapping("/executelistedit")
    public String executeListEdit(@ModelAttribute FormCapture form) {
	// get AssetList object to edit
	AssetList listAsset = (AssetList) (currentPage.getTile(form.getTileId()).getAsset(form.getAssetId()));

	// perform edit functions
	listAsset.setName( form.getName() );
	if ( form.getType().equals("ordered") )
	    listAsset.setType('o');
	else // form.getType().equals("unordered")
	    listAsset.setType('u');

	listAsset.updateContents(form.getText());
	//return form.getText();
        return pageOptions();
    }

    // Returns the HTML string necessary to gather user input in creating a new note asset
    private String newNoteHTML() {
	String retStr = "<form action='newnote' method='post'>Note Title: <input type='txt' name='name'> <br>";
	retStr += "ID: <input type='number' name='id'>";
	retStr += "<input type='submit' name='submit'> <br>";
	retStr += "</form>";
	return retStr;
    }

    @RequestMapping("/newnote")
    public String newNote(@ModelAttribute FormCapture form) {
	currentTile.addAssetNote(form.getId(), form.getName());
	return tileOptions();
    }

    
	// for prototyping only, handles loading the old dashboard save.
	public static void setup() {
		// check if save file exists
		File save = new File("src/main/save/dash_save.ser");
		
		if (save.exists())
			Application.dashboard = load();
		else
			Application.dashboard = new Dashboard();
		
	}

    
	//Handles saving the dashboard.
	@RequestMapping("/save")
	public static String save() {
		ByteCode.generateSaveFile(dashboard, "src/main/save/dash_save.ser");
		return "Your dashboard has been saved.";
	}

	// returns a dashboard object from save file
	public static Dashboard load() {
		Dashboard d = (Dashboard) ByteCode.loadFromSaveFile("src/main/save/dash_save.ser");
		return d;
	}

	@RequestMapping("/customization-tool")
	public String customizationTool() {
		return "<h1>Customization tool</h1>";
	}

	/* Launching the application */

	public static void main(String[] args) {
		Application.setup();
		SpringApplication.run(Application.class, args);
	}
}
