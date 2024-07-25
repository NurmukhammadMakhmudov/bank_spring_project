package com.example.final_project.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFormatter {

    @NotNull
    private String email;

    @NotNull
    private String password;
}
