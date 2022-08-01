package com.eukolos.arcadeblog.controller;

import com.eukolos.arcadeblog.model.AccountModel;
import com.eukolos.arcadeblog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        AccountModel account = new AccountModel();
        model.addAttribute("account", account);
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute AccountModel accountModel) {
        accountService.save(accountModel);

        return "redirect:/";
    }
}
