package com.example.final_project.controller;

import com.example.final_project.model.AccountModel;
import com.example.final_project.model.BankAccount;
import com.example.final_project.model.User;
import com.example.final_project.repo.AccountRepository;
import com.example.final_project.repo.BankAccountRepository;
import com.example.final_project.repo.UserRepository;
import com.example.final_project.service.ExchangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    private final ExchangerService exchangerService;
    private final BankAccountRepository bankAccountRepository;
    private final AccountRepository accountRepository;


    @Autowired
    public AuthController(UserRepository userRepository, ExchangerService exchangerService, BankAccountRepository bankAccountRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.exchangerService = exchangerService;
        this.bankAccountRepository = bankAccountRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
    @PostMapping("login")
    public String getUser(@ModelAttribute("user") User user){
        System.out.println(user.getEmail());
        return "redirect:/auth/success";
    }

    @GetMapping("/success")
    public String getSuccessPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName()).orElseThrow(IllegalArgumentException::new);
        System.out.println(user.getFirstName());
        BankAccount bankAccount = bankAccountRepository.findByEmail(auth.getName()).orElseThrow(IllegalArgumentException::new);
        AccountModel accountModel = accountRepository.findByBankAccountNumber(bankAccount.getBankAccountNumber()).orElseThrow(IllegalArgumentException::new);
       // model.addAttribute("currencies", exchangerService.getCurrency(LocalDate.now()));
        model.addAttribute("user", user);
        model.addAttribute("accountModel", accountModel);
        model.addAttribute("bankAccount",bankAccount);

        return "success";
    }
}