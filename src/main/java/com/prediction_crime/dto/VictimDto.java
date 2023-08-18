package com.prediction_crime.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VictimDto {

    @Id()
    @GeneratedValue
    private Long id;

    @NotNull(message = "Firstname cannot be empty!")
    @NotBlank(message = "Firstname required !")
    @Size(min = 2, max = 200, message = "Firstname size must between 2 and 100 characters")
    private String firstName;

    @NotNull(message = "Lastname cannot be empty!")
    @NotBlank(message = "Lastname required !")
    @Size(min = 2, max = 200, message = "Lastname size must between 2 and 100 characters")
    private String lastName;

    @NotNull(message = "Age cannot be empty!")
    private Integer age;

    @NotNull(message = "Gender cannot be empty!")
    @NotBlank(message = "Gender required !")
    private String gender;

    @NotNull(message = "Martial status cannot be empty!")
    @NotBlank(message = "Martial status required !")
    private String martialStatus;

    @NotNull(message = "phoneNumber cannot be empty!")
    @Digits(integer = 9, fraction = 0, message = "The phone number must have exactly 9 digits.")
    private Integer phoneNumber;

    @NotNull(message = "Address cannot be empty!")
    @NotBlank(message = "Address required !")
    @Size(min = 2, max = 200, message = "Adress size must between 2 and 200 characters")
    private String address;
}
