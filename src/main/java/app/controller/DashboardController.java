
package app.controller;

import org.springframework.ui.Model; //For Model

import org.springframework.stereotype.Controller; //For @Controller
import org.springframework.web.bind.annotation.GetMapping; //For @GetMapping
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import app.Application;
import app.FormCapture;

@Controller
public class DashboardController {

      // Default dashboard address
      // Passes the currentPage, pageList, tileList attributes from Application into the thymeleaf templates
      @GetMapping("/")
      public String dashboard(Model model, @ModelAttribute FormCapture form) {

	  if ( Application.dashboard.getPages().size() == 0 ) { // nothing in dashboard yet
	      //Pass attributes to thymeleaf
	      model.addAttribute("currentPage", null);
	      model.addAttribute("pageList", Application.dashboard.getPages());
	      model.addAttribute("tileList", null);
	      
	  }
	  else {
	      // Set default dashboard page if one is not selected
	      if (Application.currentPage == null) {
		  Application.currentPage = Application.dashboard.getPages().get(0);
		  //Application.currentPage = Application.dashboard.getPages();		  
	      }
	      //Pass attributes to thymeleaf
	      model.addAttribute("currentPage", Application.currentPage);
	      model.addAttribute("pageList", Application.dashboard.getPages());
	      model.addAttribute("tileList", Application.currentPage.getTiles());	      
	  }
            
            
            return "page";
      }

      // Request handler for changing the dashboard page
      // Points web browser to / root
      @RequestMapping("/changeDashboard")
      public RedirectView changeDashboard(@ModelAttribute FormCapture form) {
            //Update the current page
            Application.currentPage = Application.dashboard.getDashboardPage(form.getId());
            
            //Return the user back to dashboard
            return new RedirectView("/");
      }

    // Request handler for refreshing the dashboard page
    // Points we browser to / root
    @RequestMapping("/refresh")
    public RedirectView refresh(@ModelAttribute FormCapture form) {
	return new RedirectView("/");
    }

}
