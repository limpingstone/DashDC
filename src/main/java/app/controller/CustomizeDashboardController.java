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
public class CustomizeDashboardController {
    @GetMapping("/customize/")
    public String customize(Model model) {
        model.addAttribute("pageList", Application.dashboard.getPages());
        return "customizeDashboard";
    }

    @RequestMapping("/customize/newpage")
    public RedirectView newPage(@ModelAttribute FormCapture form) {
        Application.dashboard.addPage(form.getId(), form.getName());
        return new RedirectView("/customize/");
    }

    @RequestMapping("/customize/selectpage")
    public RedirectView selectPage(@ModelAttribute FormCapture form){
        Application.currentPage = Application.dashboard.getDashboardPage(form.getId());
        return new RedirectView("/customize/page/");
    }

    @RequestMapping("/customize/page/")
    public String customizePage(Model model, @ModelAttribute FormCapture form) {
		model.addAttribute("currentPage", Application.currentPage);
        model.addAttribute("pageList", Application.dashboard.getPages());
        model.addAttribute("tileList", Application.currentPage.getTiles());
        return "customizePage";
    }

    @RequestMapping("/customize/page/newtile")
    public RedirectView newTile(@ModelAttribute FormCapture form) {
        Application.currentPage.addTile(form.getId(), form.getName());
        return new RedirectView("/customize/page/");
    }

    @RequestMapping("/customize/page/selecttile")
    public RedirectView selectTile(@ModelAttribute FormCapture form){
        Application.currentTile = Application.currentPage.getTile(form.getId());
        return new RedirectView("/customize/page/tile/");
    }

    @GetMapping("/customize/page/tile/")
    public String customizeTile(Model model) {
        model.addAttribute("assetList", Application.currentTile.getAssets());
        model.addAttribute("assetTypes", Application.ASSET_TYPES);
        return "customizeTile";
    }

    @RequestMapping("/customize/page/tile/newasset")
	public String newAsset(Model model, @ModelAttribute FormCapture form) {
        model.addAttribute("type", form.getType());
        return "newAsset";
	}

	@RequestMapping("/customize/page/tile/newimage")
	public RedirectView newImage(@ModelAttribute FormCapture form) {
		int[] size = new int[] { form.getXsize(), form.getYsize() };
		int[] position = new int[] { form.getXpos(), form.getYpos() };
		Application.currentTile.addAssetImage(form.getId(), form.getName(), form.getLink(), size, position);
		return new RedirectView("/customize/page/tile/");
	}

	@RequestMapping("/customize/page/tile/newlist")
	public RedirectView newList(@ModelAttribute FormCapture form) {
		Application.currentTile.addAssetList(form.getId(), form.getName(), form.getType());
		return new RedirectView("/customize/page/tile/");
	}
}
