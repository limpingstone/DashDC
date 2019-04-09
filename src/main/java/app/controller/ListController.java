
package app.controller;

import org.springframework.ui.Model; //For Model

import java.util.List;

import org.springframework.stereotype.Controller; //For @Controller
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import app.Application;
import app.FormCapture;
import app.asset.AssetList;
import app.asset.DashboardAsset;
import app.dashboard.Tile;

@Controller
public class ListController {

    // Controller which handles all requests to edit the list
    @RequestMapping("**/editlist")
    public String editList(Model model, @ModelAttribute FormCapture form) {
        // Creates the local variables for locating list
        DashboardAsset asset = null;
        Tile tile = null;

        // Locate the list object
        List<Tile> tiles = Application.currentPage.getTiles();
        for (int i = 0; i < tiles.size(); i++) {
            tile = tiles.get(i);
            asset = tile.getAsset(form.getId());
            if (asset != null) {
                break;
            }
        }
        // Check in case asset is not found
        if (asset == null || tile == null) {
            return "List asset not found.";
        }

        // Final listAsset to be modified
        AssetList listAsset = (AssetList) asset;

        // Pass attributes to thymeleaf
        model.addAttribute("listAsset", listAsset);
        model.addAttribute("containingTile", tile);

        return "editList";
    }

    // Executed when the user has submitted edits to the list
    // Edits the list asset to save changes
    // Points the web browser to previous page
    @RequestMapping("**/executeeditlist")
    public RedirectView executeEditList(@ModelAttribute FormCapture form) {
        // Get AssetList object to edit
        AssetList listAsset = (AssetList) (Application.currentPage.getTile(form.getTileId())
                .getAsset(form.getAssetId()));

        // Perform edit functions
        listAsset.setName(form.getName());
        if (form.getType().equals("ordered"))
            listAsset.setType('o');
        else // form.getType().equals("unordered")
            listAsset.setType('u');

        listAsset.updateContents(form.getText());

        // Return the user back to previous page
        return new RedirectView("");
    }

}
