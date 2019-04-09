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

    /**
     * Source:
     * https://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
     */
    public static void open() {

        /* Creating a JFrame for the console with the appropriate parameters */
        consoleFrame = new JFrame("Dash Console");
        consoleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        consoleFrame.setSize(320, 240);

        JPanel panel = new JPanel();
        FlowLayout layout = new FlowLayout();
        panel.setLayout(layout);

        JButton launchDashboardButton = new JButton("Launch Dashboard");
        launchDashboardButton.addActionListener(e -> {
            Console.launchDashboard();
        });

        JButton launchCustomizeButton = new JButton("Customization Tool");
        launchCustomizeButton.addActionListener(e -> {
            Console.launchCustomizationTool();
        });

        JButton killJarButton = new JButton("Exit");
        killJarButton.addActionListener(e -> {
            Console.exit();
        });

        panel.add(launchDashboardButton);
        panel.add(launchCustomizeButton);
        panel.add(killJarButton);

        consoleFrame.getContentPane().add(panel);
        consoleFrame.setVisible(true);
    }

    public static void startSetup() {

    }

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

    public static void exit() {
        System.exit(0);
    }

    public static void uninstall() {

    }
}
