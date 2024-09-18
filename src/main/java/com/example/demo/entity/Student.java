package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    long id;

    @JsonIgnore
    boolean isDeleted = false;

    @NotBlank(message = "Name can not be blank")
    String name;
    @NotBlank(message = "Student code can not be blank")
    //SE123456
    @Pattern(regexp = "SE\\d{6}", message = "Student code is not valid")
    @Column(unique = true)
    String studentCode;
    @Min(value = 0, message = "Score must be at least 0")
    @Max(value = 10, message = "Scrore must not be more than 10")
    float score;


}
