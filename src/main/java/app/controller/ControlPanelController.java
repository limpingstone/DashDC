package app.controller;

import org.springframework.ui.Model; //For Model
import org.springframework.stereotype.Controller; //For @Controller
import org.springframework.web.bind.annotation.GetMapping; //For @GetMapping
import org.springframework.web.bind.annotation.RequestParam; //For @RequestParam

@Controller
public class ControlPanelController {

   // To be moved to the respective location after heirachy is determined
   private boolean advanced = false;

   @GetMapping("/control-panel")
   public String controlPanel(Model model) {
      model.addAttribute("mode", (advanced ? "Advanced" : "Basic"));
      return "control-panel";
   }
}