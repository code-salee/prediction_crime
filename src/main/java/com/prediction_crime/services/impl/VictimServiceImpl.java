package com.prediction_crime.services.impl;

import com.prediction_crime.dto.CrimeDto;
import com.prediction_crime.dto.VictimDto;
import com.prediction_crime.entities.CrimeEntity;
import com.prediction_crime.entities.VictimEntity;
import com.prediction_crime.exceptions.CrimeExceptionHandler;
import com.prediction_crime.exceptions.InvalidEntityException;
import com.prediction_crime.exceptions.VictimExceptionHandler;
import com.prediction_crime.repositories.VictimRepository;
import com.prediction_crime.services.VictimService;
import com.prediction_crime.shared.ErrorMessage;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VictimServiceImpl implements VictimService {

    private VictimRepository victimRepository;

    private ModelMapper modelMapper;

    public VictimServiceImpl(VictimRepository victimRepository, ModelMapper modelMapper) {
        this.victimRepository = victimRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VictimDto save(VictimDto victimDto) {
            VictimEntity victim = modelMapper.map(victimDto, VictimEntity.class);
            VictimEntity savedVictim = victimRepository.save(victim);
            return modelMapper.map(savedVictim, VictimDto.class);
    }

    @Override
    public List<VictimDto> findAll() {
        return victimRepository.findAll()
                .stream().map(el -> modelMapper.map(el, VictimDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VictimDto findById(Long id) {
        VictimEntity victim = victimRepository.findById(id).orElseThrow(()-> new VictimExceptionHandler("Victim ID: " + id + " not found"));
        return modelMapper.map(victim,VictimDto.class);
    }

    @Override
    public List<VictimDto> findByFirstNameAndLastName(String firstName, String lastName) {
        List<VictimEntity> person = victimRepository.findByFirstNameAndLastName(firstName, lastName);
        if(person.isEmpty()) return null;

        return person.stream().map(el -> modelMapper.map(el, VictimDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VictimDto> findByAge(Integer age) {
        List<VictimEntity> person = victimRepository.findByAge(age);
        if(person.isEmpty()) return null;

        return person.stream().map(el -> modelMapper.map(el, VictimDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VictimDto> findByGender(String gender) {
        List<VictimEntity> person = victimRepository.findByGender(gender);
        if(person.isEmpty()) return null;

        return person.stream().map(el -> modelMapper.map(el, VictimDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VictimDto> findByAddress(String address) {
        List<VictimEntity> victim = victimRepository.findByAddress(address);
        if(victim.isEmpty()) return null;

        return victim.stream().map(el -> modelMapper.map(el, VictimDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VictimDto update(VictimDto victimDto, Long id) {
        Optional<VictimEntity> victim = victimRepository.findById(id);
        if(victim.isPresent()){
            VictimEntity victimEntity = modelMapper.map(victimDto, VictimEntity.class);
            victimEntity.setId(id);
            VictimEntity updated = victimRepository.save(victimEntity);
            return modelMapper.map(updated, VictimDto.class);
        } else {
            throw new VictimExceptionHandler("Victim ID: " + id + " not found");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<VictimEntity> victim = victimRepository.findById(id);
        if(victim.isPresent()) {
            victimRepository.deleteById(id);
        } else {
            throw new VictimExceptionHandler("Crime ID: " + id + " not found");
        }
    }
}
