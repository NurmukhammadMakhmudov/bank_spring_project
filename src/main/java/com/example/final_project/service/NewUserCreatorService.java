package com.example.final_project.service;

import com.example.final_project.model.AccountModel;
import com.example.final_project.model.BankAccount;
import com.example.final_project.model.User;
import com.example.final_project.repo.AccountRepository;
import com.example.final_project.repo.BankAccountRepository;
import com.example.final_project.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class NewUserCreatorService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final BankAccountRepository bankAccountRepository;
    private final AccountRepository accountRepository;
    private final BankAccountService bankAccountService;

    @Autowired
    public NewUserCreatorService(PasswordEncoder passwordEncoder, UserRepository userRepository, BankAccountRepository bankAccountRepository, AccountRepository accountRepository, BankAccountService bankAccountService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.accountRepository = accountRepository;
        this.bankAccountService = bankAccountService;
    }


    public void CreateNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        BankAccount bankAccount1 = bankAccountService.createBankAccount(user.getId(),user.getEmail(),user.getFirstName().concat(" "+ user.getLastName()));
        bankAccountRepository.save(bankAccount1);
        AccountModel accountModel = new AccountModel(bankAccount1.getBankAccountNumber());
        accountRepository.save(accountModel);
    }
}
