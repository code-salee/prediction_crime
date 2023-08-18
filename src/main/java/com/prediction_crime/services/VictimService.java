package com.prediction_crime.services;

import com.prediction_crime.dto.VictimDto;
import java.util.List;

public interface VictimService {

    VictimDto save(VictimDto victimDto);

    List<VictimDto> findAll();

    VictimDto findById(Long id);

    List<VictimDto>  findByFirstNameAndLastName(String firstName, String lastName);

    List<VictimDto> findByAge(Integer type);

    List<VictimDto> findByGender(String place);

    List<VictimDto> findByAddress(String address);

    VictimDto update(VictimDto crimeDto, Long id);

    void delete(Long id);
}
