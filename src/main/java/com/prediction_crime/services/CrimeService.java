package com.prediction_crime.services;

import java.time.LocalDate;
import java.util.List;

import com.prediction_crime.dto.CrimeDto;

public interface CrimeService {
 
    CrimeDto save(CrimeDto crimeDto);

    List<CrimeDto> findAll();

    CrimeDto findById(Long id);

    List<CrimeDto>  findByName(String name);

    List<CrimeDto> findByType(String type);

    List<CrimeDto> findByPlace(String place);

    List<CrimeDto> findByDate(LocalDate date);

    CrimeDto update(CrimeDto crimeDto, Long id);

    void delete(Long id);
}
