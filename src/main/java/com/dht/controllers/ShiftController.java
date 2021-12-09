package com.dht.controllers;

import com.dht.pojo.Department;
import com.dht.pojo.Shift;
import com.dht.service.IDepartmentsService;
import com.dht.service.IShiftsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/shifts")
public class ShiftController {
    @Autowired
    private IShiftsService shiftsService;

    @RequestMapping()
    public String allShifts(Model model) {
        model.addAttribute("shifts", this.shiftsService.getAllShift());
        return "shifts";
    }

    @PostMapping("/delete/{shiftId}")
    public String deleteShift(@PathVariable(value = "shiftId") String shiftId) {
        this.shiftsService.deleteShift(Integer.parseInt(shiftId));
        return "redirect:/shifts";
    }

    @GetMapping("/edit-shift")
    public String editShiftView(@RequestParam(value = "shiftId", defaultValue = "") String shiftId, Model model) {
        if(shiftId != null && !shiftId.isEmpty())
            model.addAttribute("drug", this.shiftsService.getShiftById(Integer.parseInt(shiftId)));
        return "edit-shift";
    }



    @PostMapping("/edit-shift")
    public String editShift(@ModelAttribute(value = "shift") @Valid Shift p, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/";
        if(!this.shiftsService.updateShift(p)) {
            return "redirect:/";
        }
        else
            return "redirect:/shifts";
    }

    @GetMapping("/add-shift")
    public String addShiftView(Model model) {
        model.addAttribute("addshift", new Shift());
        return "add-shift";
    }

    @PostMapping("/add-shift")
    public String addShift(@ModelAttribute("addshift") Shift p, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/doctors";
        if(!this.shiftsService.addShift(p))
            return "redirect:/";
        return "redirect:/shifts";
    }
}
