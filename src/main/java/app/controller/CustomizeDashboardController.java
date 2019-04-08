package app.controller;

import org.springframework.ui.Model; //For Model
import org.springframework.stereotype.Controller; //For @Controller
import org.springframework.web.bind.annotation.GetMapping; //For @GetMapping
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam; //For @RequestParam
import org.springframework.web.servlet.view.RedirectView;

import app.Application;
import app.FormCapture;

@Controller
public class CustomizeDashboardController {
   @GetMapping("/customize")
   public String customize(Model model) {
      model.addAttribute("page", Application.dashboard.getPages());
      return "customize";
   }

// the controller to handle creating a new page (link here if you want to create a new page)
	@RequestMapping("/newpage")
    public RedirectView newPage(@ModelAttribute FormCapture form) {
        Application.dashboard.addPage(form.getId(), form.getName());
        return new RedirectView("/customize");
    }
   
}
