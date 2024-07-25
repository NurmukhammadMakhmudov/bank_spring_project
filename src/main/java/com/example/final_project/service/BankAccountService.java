package com.example.final_project.service;


import com.example.final_project.model.BankAccount;
import com.example.final_project.repo.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class BankAccountService {

    private final BankAccountGenerator bankAccountGenerator;
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountGenerator bankAccountGenerator, BankAccountRepository bankAccountRepository) {
        this.bankAccountGenerator = bankAccountGenerator;
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount createBankAccount(long user_id,String email, String fullName) {

        String cardNumber = bankAccountGenerator.cardGenerator();
        String bankAccountNumber = bankAccountGenerator.accountGenerator(email);
        String CVV =  bankAccountGenerator.CVVGenerator(new Date());
        LocalDate creationDate = LocalDate.now();
        LocalDate dateOfExpiration = LocalDate.of(creationDate.getYear() + 5, creationDate.getMonth(), creationDate.getDayOfMonth());

        return new BankAccount(user_id, email, bankAccountNumber,fullName,cardNumber,creationDate, dateOfExpiration,CVV);
    }


}

