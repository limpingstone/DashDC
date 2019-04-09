package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
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

		JFrame consoleFrame = new JFrame("Dash Console");
		consoleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        consoleFrame.setSize(320, 240);

        JPanel panel = new JPanel();
        FlowLayout layout = new FlowLayout();
        panel.setLayout(layout);

		JButton launchDashboardButton = new JButton("Launch Dashboard");
		JButton launchCustomizeButton = new JButton("Customization Tool");
		JButton killJarButton = new JButton("Exit");

		launchDashboardButton.addActionListener(e -> {
			String url = "http://127.0.0.1:8080/";
		    try {
		        if (Desktop.isDesktopSupported())
		            Desktop.getDesktop().browse(new URI(url));
		        else
		            Runtime.getRuntime().exec("xdg-open " + url);
		    } catch (IOException | URISyntaxException ex) {
		        System.out.println("Cannot open browser with url: " + url);
		    }
		});

		launchCustomizeButton.addActionListener(e -> {
			String url = "http://127.0.0.1:8080/customize/";
		    try {
		        if (Desktop.isDesktopSupported())
		            Desktop.getDesktop().browse(new URI(url));
		        else
		            Runtime.getRuntime().exec("xdg-open " + url);
		    } catch (IOException | URISyntaxException ex) {
		        System.out.println("Cannot open browser with url: " + url);
		    }
		});

		killJarButton.addActionListener(e -> {
		    System.exit(0);
		});

		panel.add(launchDashboardButton);
		panel.add(launchCustomizeButton);
		panel.add(killJarButton);

		consoleFrame.getContentPane().add(panel);
		consoleFrame.setVisible(true);

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

	// Launching the application
	public static void main(String[] args) {
		Application.setup();
		SpringApplication.run(Application.class, args);
	}
}
