package com.dht.controllers;

import com.dht.pojo.Account;
import com.dht.service.IAccountsService;
import com.dht.service.IDoctorsService;
import com.dht.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    private IAccountsService accountsService;
    @Autowired
    private IDoctorsService doctorsService;
    @Autowired
    private IRolesService rolesService;

    @RequestMapping()
    public String allAccounts(Model model) {
        model.addAttribute("accounts", this.accountsService.getAllAccount());
        return "accounts";
    }

    @PostMapping("/delete/{accountId}")
    public String deleteAccount(@PathVariable(value = "accountId") String accountId, Model model) {
        if(!this.accountsService.isAdminAccount(accountId))
            this.accountsService.deleteAccount(accountId);
        else
            model.addAttribute("errMsg", "Không thể xóa tai khoan Admin");
        return "redirect:/accounts";
    }

    @GetMapping("/edit-account")
    public String editAccountView(@RequestParam(value = "accountId", defaultValue = "") String accountId, Model model) {
        if(accountId != null)
            model.addAttribute("account", this.accountsService.getAccountById(accountId));
        model.addAttribute("roles", this.rolesService.getAllRole());
        model.addAttribute("doctors", this.doctorsService.getAllDoctor());
        return "edit-account";
    }



    @PostMapping("/edit-account")
    public String editAccount(@ModelAttribute(value = "account") @Valid Account p, BindingResult err) {
        if(err.hasErrors())
            return "redirect:/doctors";
        if(!p.getPassword().equals(p.getConfirmPassword()))
            return "redirect:/";
        else {
            if (!this.accountsService.updateAccount(p))
                return "redirect:/home";
            else
                return "redirect:/accounts";
        }
    }

    @GetMapping("/add-account")
    public String addAccountView(Model model) {
        model.addAttribute("roles", this.rolesService.getAllRole());
        model.addAttribute("doctors", this.doctorsService.getAllDoctor());
        model.addAttribute("addaccount", new Account());
        return "add-account";
    }

    @PostMapping("/add-account")
    public String addAccount(@ModelAttribute("addaccount") @Valid Account p, BindingResult err) {
        if(err.hasErrors())
            return "add-account";
//            return "redirect:/doctors";
        if(!p.getPassword().equals(p.getConfirmPassword()))
            return "redirect:/";
        else {
            if (!this.accountsService.addAccount(p))
                return "redirect:/home";
            else
                return "redirect:/accounts";
        }
    }
}
