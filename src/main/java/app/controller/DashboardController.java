package app.controller;

import org.springframework.ui.Model; //For Model
import org.springframework.stereotype.Controller; //For @Controller
import org.springframework.web.bind.annotation.GetMapping; //For @GetMapping
//import org.springframework.web.bind.annotation.RequestParam; //For @RequestParam

import app.Application;

@Controller
public class DashboardController {
   @GetMapping("/")
   public String dashboard(Model model) {
      model.addAttribute("page", Application.dashboard.getPages());
      return "dashboard";
   }
}