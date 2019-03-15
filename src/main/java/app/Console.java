import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class Console {

    // Source: https://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
    public void open() {
        String url = "http://localhost:420";

        try {
            if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(new URI(url));
            else
                Runtime.getRuntime().exec("xdg-open " + url);
        }
        catch (IOException | URISyntaxException e) {
            System.out.println("Cannot open browser with url: " + url);
        }
    }

    public void startSetup() {

    }

    public void launchDashboard() {

    }

    public void launchCustomizationTool() {

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
