package com.prediction_crime.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="crimes")
@AllArgsConstructor
@NoArgsConstructor
public class CrimeEntity {
    
    @Id()
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private LocalDate date;
}

code-salee
/
prediction_crime
