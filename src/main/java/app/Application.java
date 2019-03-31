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

	// Controll page address
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
		retStr += "You are viewinzg page: " + currentPage.getName() + "<br>";

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

		retStr += "<br><br> Add a new asset.<br><form action='newasset' method='post'>Name: <input type='text' name='name'> <br>ID: <input type='number' name='id'> <br><select name='type'>";

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
		if (type.equals("image")) {
			retStr += "<form action='newimage' method='post'>Name: <input type='text' name='name'> <br>ID: <input type='number' name='id'> <br>Link to image: <input type='text' name='link'> <br>Size x: <input type='number' name='xsize'> y: <input type='number' name='ysize'> <br>Position x: <input type='number' name='xpos'> y: <input type='number' name='ypos'> <br><input type='submit' name='submit'> <br></form>";
		}

		return retStr;
	}

	@RequestMapping("/newimage")
	public String newImage(@ModelAttribute FormCapture form) {
		int[] size = new int[] { form.getXsize(), form.getYsize() };
		int[] position = new int[] { form.getXpos(), form.getYpos() };
		currentTile.addAssetImage(form.getId(), form.getName(), form.getLink(), size, position);
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
