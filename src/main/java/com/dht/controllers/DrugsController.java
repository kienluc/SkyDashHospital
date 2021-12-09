package com.dht.controllers;

import com.dht.pojo.Drugs;
import com.dht.service.IDrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/drugs")
public class DrugsController {

    @Autowired
    private IDrugsService drugsService;

    @RequestMapping()
    public String allDrugs(Model model) {
        model.addAttribute("drugs", this.drugsService.getAllDrugs());
        return "drugs";
    }

    @PostMapping("/delete/{drugId}")
    public String deleteDrug(@PathVariable(value = "drugId") String drugId) {
        this.drugsService.deleteDrugs (Integer.parseInt(drugId));
        return "redirect:/drugs";
    }

    @GetMapping("/edit-drug")
    public String editDrugView(@RequestParam(value = "drugId", defaultValue = "") String drugId,
                               Model model) {

        if(drugId != null && !drugId.isEmpty())
            model.addAttribute("drug", this.drugsService.getDrugsById(Integer.parseInt(drugId)));
        return "edit-drug";
    }

    @PostMapping("/edit-drug")
    public String editDrug(@ModelAttribute("drug") @Valid Drugs p, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/";
        if(!this.drugsService.updateDrugs(p)) {
            return "redirect:/";
        }
        else
            return "redirect:/drugs";
    }

    @GetMapping("/add-drug")
    public String addDrugView(Model model) {
            model.addAttribute("adddrug", new Drugs());
        return "add-drug";
    }

    @PostMapping("/add-drug")
    public String addDrug(@ModelAttribute("adddrug") Drugs p, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/doctors";
        if(!this.drugsService.addDrugs(p))
            return "redirect:/";
        return "redirect:/drugs";
    }

}
