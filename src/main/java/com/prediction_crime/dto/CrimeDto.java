package com.prediction_crime.dto;

import java.time.LocalDate;
import java.util.Date;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import com.prediction_crime.entities.CrimeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrimeDto {

    @Id()
    @GeneratedValue
    private Long id;

    @NotNull(message = "Name cannot be empty!")
    @NotBlank(message = "Name required !")
    //@Size(min = 2, max = 100, message = "Name size must between 2 and 100 characters")
    private String name;

    @NotNull(message = "Type cannot be empty!")
    @NotBlank(message = "Type required !")
    private String type;

    @NotNull(message = "Place cannot be empty!")
    @NotBlank(message = "Place required !")
    private String place;

    @NotNull(message = "Date cannot be empty!")
    // @NotBlank(message = "Date required !")
    private LocalDate  date;

    //Mapping entité to dto: fromEntity permet de mapper une relation de l'entité (Crime) vers dto (CrimeDto)
    /*public static CrimeDto fromEntity (CrimeEntity crime) {
        if(crime == null){
            return null;
        }
        return CrimeDto.builder()
                .id(crime.getId())
                .name(crime.getName())
                .type(crime.getType())
                .place(crime.getPlace())
                .date(crime.getDate())
                .build();
    }


      //Mapping entité dto: toEntity permet ude mapper ne relation de dto vers l'entité
      public static CrimeEntity toEntity (CrimeDto crimeDto){
        if(crimeDto== null){
            return null;
        }
        CrimeEntity crime = new CrimeEntity();
        crime.setId(crimeDto.getId());
        crime.setName(crimeDto.getName());
        crime.setType(crimeDto.getType());
        crime.setPlace(crimeDto.getPlace());
        crime.setDate(crimeDto.getDate());
        return crime;
    }*/


}


