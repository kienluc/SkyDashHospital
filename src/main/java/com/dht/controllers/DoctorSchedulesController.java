package com.dht.controllers;

import com.dht.pojo.Department;
import com.dht.pojo.ShiftDetail;
import com.dht.service.IDepartmentsService;
import com.dht.service.IDoctorsService;
import com.dht.service.IShiftDetailsService;
import com.dht.service.IShiftsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/doctorchedules")
public class DoctorSchedulesController {
    @Autowired
    private IShiftDetailsService shiftDetailsService;
    @Autowired
    private IShiftsService shiftsService;
    @Autowired
    private IDoctorsService doctorsService;

    @RequestMapping()
    public String allDoctorSchedules(Model model) {
        model.addAttribute("shiftDetails", this.shiftDetailsService.getAllShiftDetail());
        shiftDetailsService.getAllShiftDetail().forEach(t -> {
            System.out.println(t);
        });
        return "doctorschedules";
    }
    // get All thoi nhe

    @PostMapping("/delete/{shiftdetailId}")
    public String deleteShiftDetail(@PathVariable(value = "shiftdetailId") String shiftdetailId) {
        this.shiftDetailsService.deleteShiftDetail(shiftdetailId);
        return "redirect:/doctorschedules";
    }

    @GetMapping("/edit-doctorschedule")
    public String editDoctorscheduleView(@RequestParam(value = "shiftdetailId", defaultValue = "") String shiftdetailId, Model model) {
        if(shiftdetailId != null)
            model.addAttribute("doctorscheduleco", this.shiftDetailsService.getShiftDetailById(shiftdetailId));
        return "edit-doctorschedule";
    }



    @PostMapping("/edit-doctorschedule")
    public String editDoctorschedule(@ModelAttribute(value = "doctorschedule") @Valid ShiftDetail p, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/";
        if(!this.shiftDetailsService.updateShiftDetail(p)) {
            return "redirect:/";
        }
        else
            return "redirect:/doctorschedules";
    }

    @GetMapping("/add-doctorschedule")
    public String addDoctorscheduleView(Model model) {
        model.addAttribute("doctors", this.doctorsService.getAllDoctor());
        model.addAttribute("shifts", this.shiftsService.getAllShift());
        model.addAttribute("adddoctorschedule", new ShiftDetail());
        return "add-doctorschedule";
    }

    @PostMapping("/add-doctorschedule")
    public String addDoctorschedule(@ModelAttribute("adddoctorschedule") ShiftDetail p, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/doctors";
        if(!this.shiftDetailsService.addShiftDetail(p))
            return "redirect:/";
        return "redirect:/doctorschedules";
    }
}
