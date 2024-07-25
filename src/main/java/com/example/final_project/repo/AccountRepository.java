package com.example.final_project.repo;


import com.example.final_project.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountRepository extends JpaRepository<AccountModel, Long> {
   @Query(value = "SELECT * FROM account WHERE bank_account_number=?1", nativeQuery = true)
   Optional<AccountModel> findByBankAccountNumber(String ac);
}
