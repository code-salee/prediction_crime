package com.prediction_crime.repositories;

import com.prediction_crime.dto.AdminDto;
import com.prediction_crime.dto.CrimeDto;
import com.prediction_crime.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository  extends JpaRepository<AdminEntity, Integer> {

    List<AdminDto> findByFirstNameAndLastName(String firstName, String lastName);
}
