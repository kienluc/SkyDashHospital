package com.dht.controllers;

import com.dht.pojo.Department;
import com.dht.service.IDepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/departments")
public class DepartmentsController {
    @Autowired
    private IDepartmentsService departmentsService;

    @RequestMapping()
    public String alldepartments(Model model) {
        model.addAttribute("departments", this.departmentsService.getAllDepartments());
        return "departments";
    }

    @PostMapping("/delete/{departmentId}")
    public String deletedepartment(@PathVariable(value = "departmentId") String departmentId) {
        this.departmentsService.deleteDepartment(departmentId);
        return "redirect:/departments";
    }

    @GetMapping("/edit-department")
    public String editDepartmentView(@RequestParam(value = "departmentId", defaultValue = "") String departmentId, Model model) {
        if(departmentId != null)
            model.addAttribute("department", this.departmentsService.getDepartmentById(departmentId));
        return "edit-department";
    }



    @PostMapping("/edit-department")
    public String editdepartment(@ModelAttribute(value = "department") @Valid Department p, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/";
        if(!this.departmentsService.updateDepartment(p)) {
            return "redirect:/";
        }
        else
            return "redirect:/departments";
    }

    @GetMapping("/add-department")
    public String addDepartmentView(Model model) {
        model.addAttribute("adddepartment", new Department());
        return "add-department";
    }

    @PostMapping("/add-department")
    public String addDepartment(@ModelAttribute("adddepartment") Department p, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/doctors";
        if(!this.departmentsService.addDepartment(p))
            return "redirect:/";
        return "redirect:/departments";
    }
}
