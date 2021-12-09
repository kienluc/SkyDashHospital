package com.dht.controllers;

import com.dht.pojo.Appointment;
import com.dht.service.IAppointmentsService;
import com.dht.service.IDepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@PropertySource("classpath:mail-messages.properties")
public class ClientController {
    @Autowired
    private Environment env;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private IDepartmentsService departmentsService;
    @Autowired
    private IAppointmentsService appointmentsService;

    @RequestMapping()
    public String index2() {
        return "index2";
    }

    @GetMapping()
    public String addClientAppointmentView(Model model) {
        model.addAttribute("client-appointment", new Appointment());
        model.addAttribute("departmentss", this.departmentsService.getAllDepartments());
        return "index2";
    }

    @PostMapping()
    public String addAppointment(@ModelAttribute("client-appointment") Appointment p, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/login";
        if(!this.appointmentsService.addAppointment(p))
            return "redirect:/login";
        else {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(p.getEmail());
            message.setSubject("New Appointment With Skydash Hospital");
            message.setText(env.getProperty("mail.messages.patient") + p.getName() + "!\n"
            + env.getProperty("mail.messages.appointment") + p.getId() + "\n"
            + env.getProperty("mail.messages.date") + p.getDate() + " "
            + env.getProperty("mail.messages.department") + this.departmentsService.getDepartmentById(p.getDepartment().getId()).getName()
                    + " department examination hall "
            + env.getProperty("mail.messages.hospital") + "\n"
            + env.getProperty("mail.messages.thanks"));
            this.mailSender.send(message);
            return "redirect:/";
        }
    }

//    @RequestMapping("/sendSimpleEmail")
//    public String sendSimpleEmail() {
//        return null;
//
//    }
}
