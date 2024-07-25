package com.example.final_project.service;


import com.example.final_project.model.AccountModel;
import com.example.final_project.repo.AccountRepository;
import com.example.final_project.repo.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final BankAccountRepository bankAccountRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionService(BankAccountRepository bankAccountRepository, AccountRepository accountRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountRepository = accountRepository;
    }

    public boolean makeATransactionByMail(String receiver, String sender, float transactionCashAmount){
        if (bankAccountRepository.findByEmail(receiver).isPresent()){
            AccountModel receiverAccount = accountRepository.findByBankAccountNumber(bankAccountRepository.findByEmail(receiver).get().getBankAccountNumber()).orElseThrow(null);
            AccountModel senderAccount = accountRepository.findByBankAccountNumber(bankAccountRepository.findByEmail(sender).get().getBankAccountNumber()).orElseThrow(null);
            receiverAccount.setCash(receiverAccount.getCash() + transactionCashAmount);
            senderAccount.setCash(senderAccount.getCash() - transactionCashAmount);
            return true;

        }
        return false;

    }
//    public boolean makeATransactionByPhoneNumber(String receiver, String sender, float transactionCashAmount){
//        if (bankAccountRepository.findByPhoneNumber(receiver).isPresent()){
//            AccountModel receiverAccount = accountRepository.findByBankAccountNumber(bankAccountRepository.findByPhoneNumber(receiver).get().getBankAccountNumber()).orElseThrow(null);
//            AccountModel senderAccount = accountRepository.findByBankAccountNumber(bankAccountRepository.findByEmail(sender).get().getBankAccountNumber()).orElseThrow(null);
//            receiverAccount.setCash(receiverAccount.getCash() + transactionCashAmount);
//            senderAccount.setCash(senderAccount.getCash() - transactionCashAmount);
//            return true;
//
//        }
//
//        return false;
//
//    }
    public boolean makeATransactionByBankAccount(String receiver, String sender, float transactionCashAmount){
        if (bankAccountRepository.findByBankAccountNumber(receiver).isPresent()){
            AccountModel receiverAccount = accountRepository.findByBankAccountNumber(bankAccountRepository.findByBankAccountNumber(receiver).get().getBankAccountNumber()).orElseThrow(null);
            AccountModel senderAccount = accountRepository.findByBankAccountNumber(bankAccountRepository.findByEmail(sender).get().getBankAccountNumber()).orElseThrow(null);
            receiverAccount.setCash(receiverAccount.getCash() + transactionCashAmount);
            senderAccount.setCash(senderAccount.getCash() - transactionCashAmount);
            accountRepository.save(receiverAccount);
            accountRepository.save(senderAccount);
            return true;

        }

        return false;

    }
}
