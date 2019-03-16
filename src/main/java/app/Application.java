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
        return "<h1>User Dashboard</h1>";
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
