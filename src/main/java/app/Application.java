package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import app.asset.*;
import app.dashboard.*;

@SpringBootApplication
@RestController
public class Application {
	// Temporary public to test dashboard controller
	public static Dashboard dashboard;
	// Stores the current page being viewed
	public static Page currentPage;
	// Stores the current tiles
	public static Tile currentTile;
	// Stores current assets
	public static DashboardAsset currentAsset;

	// Declares the types of assets available
    public static final String[] ASSET_TYPES = new String[] { "image", "video", "note", "list", "link", "weather" };

	// for prototyping only, handles loading the old dashboard save.
	public static void setup() {
		// Launches the console GUI
        Thread console = new Thread(new Runnable() {
            public void run() {
                Console.open();
            }
        });

		// check if save file exists
		//File save = new File("src/main/save/dash_save.ser");
		File save = new File("dash_save.ser");

		if (save.exists())
			Application.dashboard = load();
		else
			Application.dashboard = new Dashboard();

        console.start();
	}

	// returns a dashboard object from save file
	public static Dashboard load() {
		//Dashboard d = (Dashboard) ByteCode.loadFromSaveFile("src/main/save/dash_save.ser");
		Dashboard d = (Dashboard) ByteCode.loadFromSaveFile("dash_save.ser");
		return d;
	}

	// Launching the application
	public static void main(String[] args) {
		Application.setup();
		SpringApplication.run(Application.class, args);
	}
}
