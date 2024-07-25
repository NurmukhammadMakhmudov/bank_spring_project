package com.example.final_project.service;
import com.example.final_project.exaptions.UsernameWasUsed;
import com.example.final_project.model.BankAccount;
import com.example.final_project.repo.BankAccountRepository;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class BankAccountGenerator {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountGenerator(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }


    public String accountGenerator(String email){
        if (bankAccountRepository.findByLastCardInfo().isPresent()){
            BigInteger bigInteger = new BigInteger(bankAccountRepository.findByLastCardInfo().get().getBankAccountNumber());

            return bigInteger.add(BigInteger.ONE).toString();
        }

       return "11111111111110000001";

    }

    public String cardGenerator(){
        if (bankAccountRepository.findByLastCardInfo().isPresent()) {
            BigInteger bigInteger = new BigInteger(bankAccountRepository.findByLastCardInfo().get().getCardNumber());
            return bigInteger.add(BigInteger.ONE).toString();
        }

        return "8600490417254455";

    }

    public String CVVGenerator(@NotNull Date date) {
        Random random = new Random();
        random.setSeed(date.getTime());
        return String.valueOf( random.nextInt(1000));
    }
}
