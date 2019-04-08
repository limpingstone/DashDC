
package app.controller;

import org.springframework.ui.Model; //For Model

import java.util.List;

import org.springframework.stereotype.Controller; //For @Controller
import org.springframework.web.bind.annotation.GetMapping; //For @GetMapping
//import org.springframework.web.bind.annotation.RequestParam; //For @RequestParam
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import app.Application;
import app.FormCapture;
import app.dashboard.Tile;

@Controller
public class PageController {
// Controll page address
	@RequestMapping("/dashboard")
	public String pageOptions(Model model) {
      model.addAttribute("dashboard", Application.dashboard);
      model.addAttribute("page", Application.dashboard.getPages().get(2));
      model.addAttribute("tileList", Application.dashboard.getPages().get(2).getTiles());
      //model.addAttribute("display", Application.dashboard.getPages().get(0).getTiles().display());
      return "page";
	}
}
