
package app.controller;

import org.springframework.ui.Model; //For Model

import java.util.List;

import org.springframework.stereotype.Controller; //For @Controller
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import app.Application;
import app.FormCapture;
import app.asset.AssetNote;
import app.asset.DashboardAsset;
import app.dashboard.Tile;

@Controller
public class NoteController {

    // Controller which handles all requests to edit the list
    @RequestMapping("**/editnote")
    public String editNote(Model model, @ModelAttribute FormCapture form) {
        // Get the asset object to edit
        DashboardAsset asset = null;
        Tile tile = null;
        List<Tile> tiles = Application.currentPage.getTiles();
        for (int i = 0; i < tiles.size(); i++) {
            tile = tiles.get(i);
            asset = tile.getAsset(form.getId());
            if (asset != null)
                break;
        }
        if (asset == null || tile == null) // asset not found
            return "Note asset not found.";

        // Create the AssetNote that wants to be edited
        AssetNote noteAsset = (AssetNote) asset;

        // Pass attributes to thymeleaf
        model.addAttribute("noteAsset", noteAsset);
        model.addAttribute("containingTile", tile);

        return "editNote";
    }
    
    // Executed when the user has submitted edits to the note
    // Edits the note asset to save changes
    // Points the web browser to previous page
    @RequestMapping("**/executeeditnote")
    public RedirectView executeEditNote(@ModelAttribute FormCapture form) {
        // Get AssetNote object to edit
        AssetNote noteAsset = (AssetNote) (Application.currentPage.getTile(form.getTileId()).getAsset(form.getAssetId()));

        // Perform edit functions
        noteAsset.setName(form.getName());
        noteAsset.setContents(form.getText());

        // Return the user back to previous page
        return new RedirectView("");
    }

}
