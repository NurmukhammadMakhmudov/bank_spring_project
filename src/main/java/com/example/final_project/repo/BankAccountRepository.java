package com.example.final_project.repo;

import com.example.final_project.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    Optional<BankAccount> findByEmail(String email);


    Optional<BankAccount> findByCardNumber(String cardNumber);
    Optional<BankAccount> findByBankAccountNumber(String bankAccount);
    @Query(value = "SELECT * FROM card_info ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Optional<BankAccount> findByLastCardInfo();
}
