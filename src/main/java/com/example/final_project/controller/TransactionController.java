package com.example.final_project.controller;


import com.example.final_project.model.AccountModel;
import com.example.final_project.model.BankAccount;
import com.example.final_project.model.User;
import com.example.final_project.service.TransactionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping
    public String transactionMakeOption() {
        return "transactionOptions";

    }



    @GetMapping("/transactionByPhoneNumber")
    public String byPhoneNumberForm(Model model, BankAccount bankAccount) {
        model.addAttribute("bankAccount", bankAccount);
        return "transaction_by_bank_account";

    }

    @PostMapping("/transactionByPhoneNumber")
    public String byPhoneNumber(User user,BankAccount bankAccount) {


        return "redirect:/auth/success";

    }

    @GetMapping("/transactionByEmail")
    public String byEmailForm(Model model, BankAccount bankAccount) {
        model.addAttribute("bankAccount", bankAccount);
        return "transaction_by_bank_account";

    }

    @PostMapping("/transactionByEmail")
    public String byEmail(User user,BankAccount bankAccount) {


        return "redirect:/auth/success";

    }

    @GetMapping("/transaction_by_bank_account")
    public String byBankAccountForm(Model model, BankAccount bankAccount, AccountModel cashAmount) {
        model.addAttribute("bankAccount", bankAccount);
        model.addAttribute("cashAmount", cashAmount);
        return "transaction_by_bank_account";

    }

    @PostMapping("/transaction_by_bank_account")
    public String byBankAccount(BankAccount bankAccount,AccountModel cashAmount) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        transactionService.makeATransactionByBankAccount(bankAccount.getBankAccountNumber(),auth.getName(),cashAmount.getCash());


        return "redirect:/auth/success";

    }

}
