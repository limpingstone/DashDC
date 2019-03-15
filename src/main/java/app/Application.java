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
        String agregate = "<h1>User Dashboard</h1>";
        int[] assetSize = new int[2];
        int[] assetPosition = new int[2];
        AssetImage cat = new AssetImage("hello", assetSize, assetPosition);
        agregate += cat.display();
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
