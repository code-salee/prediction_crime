package com.prediction_crime.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prediction_crime.entities.CrimeEntity;

@Repository
public interface CrimeRepository extends JpaRepository<CrimeEntity, Long>{

    List<CrimeEntity> findByName(@Param("name") String name);

    List<CrimeEntity> findByType(String type);

    List<CrimeEntity> findByPlace(@Param("place") String place);

    List<CrimeEntity> findByDate(LocalDate date);
}
