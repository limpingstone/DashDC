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
	public static Page currentPage;
	// Stores the current tiles (PROTO)
	public static Tile currentTile;
	// Stores current assets (PROTO)
	public static DashboardAsset currentAsset;

	// Declares the types of assets available
	public static final String[] ASSET_TYPES = new String[] { "image", "note", "list" };

	// for prototyping only, handles loading the old dashboard save.
	public static void setup() {
		// check if save file exists
		File save = new File("src/main/save/dash_save.ser");

		if (save.exists())
			Application.dashboard = load();
		else
			Application.dashboard = new Dashboard();

	}

	// Handles saving the dashboard.
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

	/* Launching the application */
	public static void main(String[] args) {
		Application.setup();
		SpringApplication.run(Application.class, args);
	}
}
