package com.prediction_crime.services;

import com.prediction_crime.dto.AdminDto;

import java.util.List;

public interface AdminService {

    AdminDto save(AdminDto adminDto);

    List<AdminDto> findAll();

    AdminDto findById(Integer id);

    List<AdminDto> findByFirstNameAndLastName(String firstName, String lastName);

    AdminDto update(AdminDto adminDto, Integer id);

    void delete(Integer id);

}
