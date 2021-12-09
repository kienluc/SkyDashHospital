/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;


import com.dht.service.IDepartmentsService;
import com.dht.service.IDoctorsService;
import com.dht.service.IPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Admin
 */
@Controller
public class HomeController {

    @Autowired
    private IDoctorsService doctorsService;

    @RequestMapping("/home")
    public String index() {
        return "index";
    }




    /**
     *
     * Cac trang doctor schedule
     *
     */

    @RequestMapping("/doctorschedules")
    public String doctorschedules() {
        return "doctorschedules";
    }

    /**
     *
     * Cac trang bills
     */



}
