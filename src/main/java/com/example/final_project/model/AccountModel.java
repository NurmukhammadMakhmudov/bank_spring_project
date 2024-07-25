package com.example.final_project.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "account")
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cash")
    private float cash;
    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    public AccountModel(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public AccountModel() {

    }
}
