package com.example.final_project.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private String roleName = "USER";
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "pass_word")
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "isactive")
    private Boolean isActive = true;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private BankAccount bankAccount;


}
