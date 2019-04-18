
package app.controller;

import org.springframework.ui.Model; //For Model

import java.util.List;

import org.springframework.stereotype.Controller; //For @Controller
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import app.Application;
import app.ByteCode;
import app.FormCapture;
import app.asset.AssetNote;
import app.asset.DashboardAsset;
import app.dashboard.Tile;

@Controller
public class SaveController {
    // Controller which handles all requests to save the dashboard no matter what
    // page you do it from
    @RequestMapping("**/save")
    public String saveController(Model model, @ModelAttribute FormCapture form) {
        // Call the bytecode to save the method.
        //ByteCode.generateSaveFile(Application.dashboard, "src/main/save/dash_save.ser");
        ByteCode.generateSaveFile(Application.dashboard, "dash_save.ser");
        return "saveDashboard";
    }

    // Allows for the redirect back to the previous page
    @RequestMapping("**/executesave")
    public RedirectView executeSave(@ModelAttribute FormCapture form) {
        return new RedirectView("");
    }

}
