package app.dashboard;

import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import app.ByteCode;

public class Console {

    // Source:
    // https://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
    public void open() {
        String url = "http://localhost:8080/control-panel";

        try {
            if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(new URI(url));
            else
                Runtime.getRuntime().exec("xdg-open " + url);
        } catch (IOException | URISyntaxException e) {
            System.out.println("Cannot open browser with url: " + url);
        }
    }

    public void startSetup() {

    }

    public void launchDashboard() {
        String url = "http://localhost:8080";

        try {
            if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(new URI(url));
            else
                Runtime.getRuntime().exec("xdg-open " + url);
        } catch (IOException | URISyntaxException e) {
            System.out.println("Cannot open browser with url: " + url);
        }
    }

    public void launchCustomizationTool() {
        String url = "http://localhost:8080/customization-tool";

        try {
            if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(new URI(url));
            else
                Runtime.getRuntime().exec("xdg-open " + url);
        } catch (IOException | URISyntaxException e) {
            System.out.println("Cannot open browser with url: " + url);
        }
    }

    public void closeCustomizationTool() {

    }

    public void getMode() {

    }

    public void setMode(boolean advanced) {

    }

    public ByteCode writeContents(Dashboard dash, CustomizeDashboard customDash) {
        return null;
    }

    public void save(ByteCode output, String filePath) {

    }

    public void backup(ByteCode output) {

    }

    public void exit() {

    }

    public void uninstall() {

    }
}
