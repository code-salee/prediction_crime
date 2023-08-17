package com.prediction_crime.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

    @Id()
    @GeneratedValue
    private Long id;

    @NotNull(message = "Firstname cannot be empty!")
    @NotBlank(message = "Firstname required !")
    @Size(min = 2, max = 100, message = "Firstname size must between 2 and 100 characters")
    private String firstName;

    @NotNull(message = "Lastname cannot be empty!")
    @NotBlank(message = "Lastname required !")
    @Size(min = 2, max = 100, message = "Lastname size must between 2 and 100 characters")
    private String lastName;

    @NotNull(message = "Call cannot be empty!")
    @NotBlank(message = "Call required !")
    @Size(min = 9, max = 9, message = "Call size must be 9 characters")
    private String call;

    @NotNull(message = "Lastname cannot be empty!")
    @NotBlank(message = "Lastname required !")
    @Size(min = 2, max = 200, message = "Lastname size must between 2 and 200 characters")
    private String adress;

    /*@Column(nullable = false)
    private LocalDate username;

    @Column(nullable = false)
    private LocalDate password;*/
}