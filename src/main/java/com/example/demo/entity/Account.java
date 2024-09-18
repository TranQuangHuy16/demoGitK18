package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự generate id
    long id;

    //KHXXXXXX
    @NotBlank(message = "Code can not be blank")
    @Pattern(regexp = "KH\\d{6}", message = "Invalid code")
    @Column(unique = true)
    String code;

    @Email(message = "Invalid email")
    String email;

    @Pattern(regexp = "(84|0[3|5|7|8|9])+(\\d{8})", message = "Invalid phone number")
    String phone;

    @Size(min = 6, message = "Password must at lease 6 characters")
    String password;
}
