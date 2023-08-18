package com.prediction_crime.repositories;

import com.prediction_crime.dto.VictimDto;
import com.prediction_crime.entities.VictimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VictimRepository extends JpaRepository<VictimEntity, Long> {


    List<VictimEntity> findByFirstNameAndLastName(String firstName, String lastName);

    List<VictimEntity> findByAge(Integer type);

    List<VictimEntity> findByGender(String gender);

    List<VictimEntity> findByAddress(String address);
}
