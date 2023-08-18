package com.prediction_crime.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="victims")
@AllArgsConstructor
@NoArgsConstructor
public class VictimEntity {

    @Id()
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String martialStatus;

    @Column(nullable = false)
    private Integer phoneNumber;

    @Column(nullable = false)
    private String address;
}
