package com.example.final_project.controller;

import com.example.final_project.model.AccountModel;
import com.example.final_project.model.BankAccount;
import com.example.final_project.model.User;
import com.example.final_project.repo.AccountRepository;
import com.example.final_project.repo.BankAccountRepository;
import com.example.final_project.repo.UserRepository;
import com.example.final_project.service.BankAccountService;
import com.example.final_project.service.NewUserCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class Registration {

    private final NewUserCreatorService newUserCreatorService;

    private final UserRepository userRepository;

    private final BankAccountService bankAccountService;
    private final BankAccountRepository bankAccountRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public Registration(NewUserCreatorService newUserCreatorService, UserRepository userRepository, BankAccountService bankAccountService, BankAccountRepository bankAccountRepository, AccountRepository accountRepository) {
        this.newUserCreatorService = newUserCreatorService;
        this.userRepository = userRepository;
        this.bankAccountService = bankAccountService;
        this.bankAccountRepository = bankAccountRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public String newUserForm(Model model, User user) {
        model.addAttribute("user", user);
        return "registration";

    }

    @PostMapping
    public String newUser(User user) {
        newUserCreatorService.CreateNewUser(user);

        return "redirect:/auth/success";

    }

    @GetMapping("/add_new_card")
    public String addNewCard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName()).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        BankAccount bankAccount = bankAccountRepository.findByEmail(auth.getName()).orElseThrow(()-> new UsernameNotFoundException("Account not found "));
        BankAccount bankAccount1 = bankAccountService.createBankAccount(user.getId(),user.getEmail(),user.getFirstName().concat(" " + user.getLastName()));
        bankAccountRepository.save(bankAccount1);
        AccountModel accountModel = new AccountModel(bankAccount1.getBankAccountNumber());
        accountRepository.save(accountModel);

        return "add_new_card";
    }

}
