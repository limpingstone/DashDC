package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @RequestMapping("/control")
    public String control() {
        return "<h1>control</h1>\n<p>This is <em>in</em> a paragraph</p>\n<p>With a link to <a href=\"https://www.youtube.com\">youtube</a></p>";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
