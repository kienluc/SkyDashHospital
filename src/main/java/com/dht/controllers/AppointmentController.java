package com.dht.controllers;

import com.dht.pojo.Appointment;
import com.dht.pojo.Patient;
import com.dht.repository.IAppointmentsRepository;
import com.dht.service.IAccountsService;
import com.dht.service.IAppointmentsService;
import com.dht.service.IDepartmentsService;
import com.dht.service.IPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private Environment env;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private IPatientsService patientsService;
    @Autowired
    private IDepartmentsService departmentsService;
    @Autowired
    private IAppointmentsService appointmentsService;

    @RequestMapping()
    public String allAppointments(Model model) {
        model.addAttribute("appointments", this.appointmentsService.getAllAppointment());
        return "appointments";
    }
    @PostMapping("/delete/{appointmentId}")
    public String deleteAppointment(@PathVariable(value = "appointmentId") int appointmentId) {
        this.appointmentsService.deleteAppointment(appointmentId);
        return "redirect:/appointments";
    }

    @GetMapping("/edit-appoinment")
    public String editAppointmentView(@RequestParam(value = "appointmentId", defaultValue = "") String appointmentId, Model model) {
        if(appointmentId != null)
            model.addAttribute("appoinment", this.appointmentsService.getAppointmentById(appointmentId));
        return "edit-appoinment";
    }



    @PostMapping("/edit-appoinment")
    public String editAppointment(@ModelAttribute(value = "appoinment") @Valid Appointment p, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/";
        if(!this.appointmentsService.updateAppointment(p)) {
            return "redirect:/";
        }
        else
            return "redirect:/appoinments";
    }

    @GetMapping("/add-appointment/{patientId}")
    public String addAppointmentView(@PathVariable("patientId") String patientId, Model model) {
        model.addAttribute("addappointment", new Appointment());
        model.addAttribute("patientss", this.patientsService.getPatientById(patientId));
        model.addAttribute("departmentss", this.departmentsService.getAllDepartments());
        return "add-appointment";
    }

    @PostMapping("/add-appointment/{patientId}")
    public String addAppointment(@ModelAttribute("addappointment") Appointment a,
                                 @PathVariable("patientId") String patientId, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/";
        Patient p = this.patientsService.getPatientById(patientId);
        a.setName(p.getName());
        a.setCcid(p.getCcid());
        a.setEmail(p.getEmail());
        a.setPhone(p.getPhone());
        if(!this.appointmentsService.addAppointment(a))
            return "redirect:/";
        else {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(p.getEmail());
            message.setSubject("New Appointment With Skydash Hospital");
            message.setText(env.getProperty("mail.messages.patient") + a.getName() + "!\n"
                    + env.getProperty("mail.messages.appointment") + a.getId() + "\n"
                    + env.getProperty("mail.messages.date") + a.getDate() + " "
                    + env.getProperty("mail.messages.department") + this.departmentsService.getDepartmentById(a.getDepartment().getId()).getName()
                    + " department examination hall "
                    + env.getProperty("mail.messages.hospital") + "\n"
                    + env.getProperty("mail.messages.thanks"));
            this.mailSender.send(message);
            return "redirect:/appointments";
        }
    }

}
