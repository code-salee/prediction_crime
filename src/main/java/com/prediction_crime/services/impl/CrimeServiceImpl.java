package com.prediction_crime.services.impl;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.prediction_crime.entities.CrimeEntity;
import com.prediction_crime.exceptions.CrimeExceptionHandler;
import com.prediction_crime.exceptions.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.prediction_crime.dto.CrimeDto;
import com.prediction_crime.repositories.CrimeRepository;
import com.prediction_crime.services.CrimeService;


@Service
public class CrimeServiceImpl implements CrimeService {

    private CrimeRepository crimeRepository;

    private ModelMapper modelMapper;

    public CrimeServiceImpl(CrimeRepository crimeRepository, ModelMapper modelMapper) {
        this.crimeRepository = crimeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrimeDto save(CrimeDto crimeDto) {
        CrimeEntity crime = modelMapper.map(crimeDto, CrimeEntity.class);
        CrimeEntity savedCrime = crimeRepository.save(crime);
        return modelMapper.map(savedCrime, CrimeDto.class);
    }

    @Override
    public List<CrimeDto> findAll() {
        return crimeRepository.findAll()
                .stream().map(el -> modelMapper.map(el, CrimeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CrimeDto findById(Long id) {
        CrimeEntity crimeEntity = crimeRepository.findById(id).orElseThrow(()-> new CrimeExceptionHandler("Crime ID: " + id + " not found"));
        return modelMapper.map(crimeEntity,CrimeDto.class);
    }

    @Override
    public List<CrimeDto> findByName(String name) {
        List<CrimeEntity> crime = crimeRepository.findByName(name);
        if(crime.isEmpty()) return null;

            return crime.stream().map(el -> modelMapper.map(el, CrimeDto.class))
                    .collect(Collectors.toList());
    }

    @Override
    public List<CrimeDto> findByPlace(String place) {
        List<CrimeEntity> crime = crimeRepository.findByPlace(place);
        if(crime.isEmpty()) return null;

        return crime.stream().map(el -> modelMapper.map(el, CrimeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public  List <CrimeDto> findByType(String type) {
        List<CrimeEntity> crime = crimeRepository.findByType(type);
        if(crime.isEmpty()) return null;

        return crime.stream().map(el -> modelMapper.map(el, CrimeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public  List <CrimeDto> findByDate(LocalDate date) {
        List<CrimeEntity> crime = crimeRepository.findByDate(date);
        if(crime.isEmpty()) return null;

        return crime.stream().map(el -> modelMapper.map(el, CrimeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CrimeDto update(CrimeDto crimeDto, Long id) {
        Optional<CrimeEntity> crime = crimeRepository.findById(id);
        if(crime.isPresent()){
            CrimeEntity crimeEntity = modelMapper.map(crimeDto, CrimeEntity.class);
            crimeEntity.setId(id);
            CrimeEntity updated = crimeRepository.save(crimeEntity);
            return modelMapper.map(updated, CrimeDto.class);
        } else {
            throw new CrimeExceptionHandler("Crime ID: " + id + " not found");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<CrimeEntity> crime = crimeRepository.findById(id);
        if(crime.isPresent()) {
            crimeRepository.deleteById(id);
        } else {
        throw new CrimeExceptionHandler("Crime ID: " + id + " not found");
        }
    }
}