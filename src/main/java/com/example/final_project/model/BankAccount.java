package com.example.final_project.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card_info")
public class BankAccount {


    public BankAccount(long user_id, String email, String bankAccountNumber, String fullName, String cardNumber, LocalDate creationDate, LocalDate dateOfExpiration, String CVV) {
        this.user_id = user_id;
        this.email = email;
        this.bankAccountNumber = bankAccountNumber;
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.creationDate = creationDate;
        this.dateOfExpiration = dateOfExpiration;
        this.CVV = CVV;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private long user_id;
    @Column(name = "email")
    private String email;
    @Column(name = "bank_account_number")
    private String bankAccountNumber;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column(name = "date_of_expiration")
    private LocalDate dateOfExpiration;
    @Column(name = "cvv")
    private String CVV;
    @Column(name = "cash")
    private float cash;


}
