package com.prediction_crime.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="admins")
@AllArgsConstructor
@NoArgsConstructor
public class AdminEntity {

    @Id()
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    /*@Column(nullable = false)
    private LocalDate username;

    @Column(nullable = false)
    private LocalDate password;*/
}