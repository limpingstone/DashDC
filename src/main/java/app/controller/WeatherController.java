
package app.controller;

import org.springframework.stereotype.Controller; //For @Controller
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class WeatherController {
    // Request handler for refreshing the dashboard page
    // Points we browser to / root
    @RequestMapping("**/refreshWeather")
    public RedirectView refreshWeather() {
        return new RedirectView("");
    }

}
