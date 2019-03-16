package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {


    private static Dashboard dashboard;
    private static Page currentPage; // current page the viewer is seeing
    // may be unnecessary
    private static Tile currentTile;
    //    private static Asset currentAsset;
    
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

	/*
	int[] assetSize = {400,400};
	int[] assetPosition = new int[2];
	AssetImage cat = new AssetImage("https://upload.wikimedia.org/wikipedia/commons/e/eb/Ash_Tree_-_geograph.org.uk_-_590710.jpg", assetSize, assetPosition);
	retStr += cat.display();
	*/
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

	retStr += "You are viewing page: " + currentPage.getName() + "<br>";
	List<Tile> tiles = currentPage.getTiles();
	for ( int i = 0; i < tiles.size(); i++ )
	    retStr += tiles.get(i).getName() + "<br>";
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


    
    @RequestMapping("/newtile")
    public String newTile(@ModelAttribute FormCapture form) {
	currentPage.addTile(form.getId(), form.getName());
	return pageOptions();
    }
	    
    // for prototyping only
    public static void setup() {
	Application.dashboard = new Dashboard();
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
