
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

    @RequestMapping("**/editlist")
    public String editList(Model model, @ModelAttribute FormCapture form) {
        DashboardAsset asset = null;
        Tile tile = null;

        List<Tile> tiles = Application.currentPage.getTiles();
        for (int i = 0; i < tiles.size(); i++) {
            tile = tiles.get(i);
            asset = tile.getAsset(form.getId());
            if (asset != null) {
                break;
            }
        }
        if (asset == null || tile == null) {// asset not found
            return "List asset not found.";
        }
        // the AssetList that wants to be edited
        AssetList listAsset = (AssetList) asset;

        model.addAttribute("listAsset", listAsset);
        model.addAttribute("containingTile", tile);
        return "editList";
    }

    @RequestMapping("**/executeeditlist")
    public RedirectView changeDashboard(@ModelAttribute FormCapture form) {
        // get AssetList object to edit
		AssetList listAsset = (AssetList) (Application.currentPage.getTile(form.getTileId()).getAsset(form.getAssetId()));

		// perform edit functions
		listAsset.setName(form.getName());
		if (form.getType().equals("ordered"))
			listAsset.setType('o');
		else // form.getType().equals("unordered")
			listAsset.setType('u');

		listAsset.updateContents(form.getText());
        
        //Currently returns user back to dashboard if editing list
        return new RedirectView("");
    }
    

}
