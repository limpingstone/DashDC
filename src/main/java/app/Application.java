package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    
    /*  Determining addresses for springboot    */
    @RequestMapping("/")
    public String dash() {

        /*  Testing images  */
        String agregate = "<h1>User Dashboard</h1>";
        int[] assetSize = {400,400};
        int[] assetPosition = new int[2];
        AssetImage cat = new AssetImage("https://upload.wikimedia.org/wikipedia/commons/e/eb/Ash_Tree_-_geograph.org.uk_-_590710.jpg", assetSize, assetPosition);
        agregate += cat.display();
        /*  End image test*/

        return agregate;
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
        SpringApplication.run(Application.class, args);
    }
}
