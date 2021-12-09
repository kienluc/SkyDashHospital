package com.dht.controllers;

import com.dht.pojo.BillDetails;
import com.dht.pojo.Bills;
import com.dht.service.IBillDetailsService;
import com.dht.service.IBillsService;
import com.dht.service.IDrugsService;
import com.dht.service.IPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private IBillDetailsService billDetailsService;
    @Autowired
    private IBillsService billsService;
    @Autowired
    private IDrugsService drugsService;
    @Autowired
    private IPatientsService patientsService;

    @RequestMapping()
    public String bill() {
        return "bills";
    }

    @GetMapping("/add-bill")
    public String addBill(Model model) {
        model.addAttribute("drugs", this.drugsService.getAllDrugs());
        model.addAttribute("addbill", new Bills());
        return "add-bill";
    }

    @PostMapping("/add-bill")
    public String addBill(@ModelAttribute("addbill") Bills b, BindingResult err) {
        if(!err.hasErrors()){
            try {
                System.out.println("Controller: " + b.getStr());
                String[] arr = b.getStr().split(";");
                b.setPatientid(patientsService.getPatientById(b.getCcid()));
                billsService.addBills(b);
                for(String s : arr) {
                    String[] pairs = s.split("-");
                    String idThuoc = pairs[0];
                    String quantity = pairs[1];
                    BillDetails billDetails = new BillDetails();
                    billDetails.setBill(b);
                    billDetails.setAmount(Integer.parseInt(quantity));
                    billDetails.setDrug(drugsService.getDrugsById(Integer.parseInt(idThuoc)));
                    // to chua co template billdetail nen danh` nhin` mysql vay
                    billDetailsService.addBillDetails(billDetails);
                }
                return "redirect:/";
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "bills";
    }

}
