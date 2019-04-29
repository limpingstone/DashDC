package app.dashboard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import app.ByteCode;

public class Console {

    private static JFrame consoleFrame;

    /** The method that launches the console GUI */
    public static void open() {

        /* Creating a JFrame for the console with the appropriate parameters */
        consoleFrame = new JFrame("Dash Console");
        consoleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        consoleFrame.setSize(320, 240);

        /* Initializing a panel with horizontal layout for the buttons */
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Button to launch dashboard in the browser
        JButton launchDashboardButton = new JButton("Launch Dashboard");
        launchDashboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        launchDashboardButton.setEnabled(false);
        launchDashboardButton.addActionListener(e -> {
            Console.launchDashboard();
        });

        // Button to launch customization tool in the browser
        JButton launchCustomizeButton = new JButton("Customization Tool");
        launchCustomizeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        launchCustomizeButton.setEnabled(false);
        launchCustomizeButton.addActionListener(e -> {
            Console.launchCustomizationTool();
        });

        // Button to end the program
        JButton killJarButton = new JButton("Exit");
        killJarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        killJarButton.addActionListener(e -> {
            Console.exit();
        });

        // Label showing status of initializing the program
        JLabel status = new JLabel("Loading Modules...");
        status.setAlignmentX(Component.CENTER_ALIGNMENT);

        /* Add the buttons to the panel in order */
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(status);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(launchDashboardButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(launchCustomizeButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(killJarButton);

        /* Add the panel to the frame and display the frame */
        consoleFrame.getContentPane().add(panel);
        consoleFrame.setVisible(true);

        /* Enabling the buttons after waiting for Spring boot to launch in the background */
        try {
            Thread.sleep(5000);
            launchDashboardButton.setEnabled(true);
            launchCustomizeButton.setEnabled(true);
            status.setText("Welcome to Dash DC!");
        } catch (InterruptedException e) {
            System.out.print("Error launching Dashboard functionalities");
        }
    }

    // STUB
    public static void startSetup() {

    }

    /**
     * The method that launches the dashboard in the system's default browser
     * Source:
     * https://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
     */
    public static void launchDashboard() {
        String url = "http://127.0.0.1:8080/";
        try {
            if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(new URI(url));
            else
                Runtime.getRuntime().exec("xdg-open " + url);
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Cannot open browser with url: " + url);
        }
    }

    /**
     * The method that launches the customization tool page in the system's default browser
     * Source:
     * https://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
     */
    public static void launchCustomizationTool() {
        String url = "http://127.0.0.1:8080/customize/";
        try {
            if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(new URI(url));
            else
                Runtime.getRuntime().exec("xdg-open " + url);
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Cannot open browser with url: " + url);
        }
    }

    /* STUBS */
    public static void closeCustomizationTool() {

    }

    public static void getMode() {

    }

    public static void setMode(boolean advanced) {

    }

    public static ByteCode writeContents(Dashboard dash, CustomizeDashboard customDash) {
        return null;
    }

    public static void save(ByteCode output, String filePath) {

    }

    public static void backup(ByteCode output) {

    }

    /** The method for exiting the program. */
    public static void exit() {
        System.exit(0);
    }

    public static void uninstall() {

    }
}
