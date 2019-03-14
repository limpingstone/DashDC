package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@SpringBootApplication
@RestController
public class Application {

    private static Dashboard dashboard;
    
    @RequestMapping("/")
    public String home() {
	String retStr = "Here are the pages that currently exist: <br>";
	retStr += dashboard.getPageNames().toString();
	retStr += "<br> Add a new page.<br>";
	retStr += "<form action='landing' method='post'>";
	retStr += "Name: <input type='text' name='name'> <br>";
	retStr += "ID: <input type='number' name='id'> <br>";
	retStr += "<input type='submit' name='submit'> <br>";
	return retStr;
	    
    }

    @RequestMapping("/landing")
    public String land(@ModelAttribute FormCapture form) {
	dashboard.addPage(form.getId(), form.getName());
	return home();
    }

    // for prototyping only
    public static void setup() {
	Application.dashboard = new Dashboard();
    }
    
    public static void main(String[] args) {
	Application.setup();
        SpringApplication.run(Application.class, args);
    }
}
