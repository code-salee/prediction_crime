package com.prediction_crime.services.impl;

import com.prediction_crime.dto.AdminDto;
import com.prediction_crime.entities.AdminEntity;
import com.prediction_crime.exceptions.EntityNotFoundException;
import com.prediction_crime.repositories.AdminRepository;
import com.prediction_crime.services.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    private ModelMapper modelMapper;

    public AdminServiceImpl(AdminRepository adminRepository, ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AdminDto save(AdminDto adminDto) {
        if(adminDto == null) return null;
        AdminEntity adminEntity = modelMapper.map(adminDto,AdminEntity.class);
        AdminEntity savedAdmin = adminRepository.save(adminEntity);
        return modelMapper.map(savedAdmin, AdminDto.class);
    }

    @Override
    public List<AdminDto> findAll() {
        return adminRepository.findAll()
                .stream().map(el -> modelMapper.map(el, AdminDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdminDto findById(Integer id) {
        AdminEntity adminEntity = adminRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Admin ID not found"));
        return modelMapper.map(adminEntity, AdminDto.class);     }

    @Override
    public List<AdminDto> findByFirstNameAndLastName(String firstName, String lastName) {

        if(firstName == null && lastName == null) return null;

        return adminRepository.findByFirstNameAndLastName(firstName, lastName)
                .stream().map(el -> modelMapper.map(el, AdminDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdminDto update(AdminDto adminDto, Integer id) {
        Optional<AdminEntity> admin = adminRepository.findById(id);
        if(admin.isPresent()){
            AdminEntity adminEntity = modelMapper.map(adminDto, AdminEntity.class);
            adminEntity.setId(id);
            AdminEntity updated = adminRepository.save(adminEntity);
            return modelMapper.map(updated, AdminDto.class);
        } else {
            throw new EntityNotFoundException("Admin not found");
        }
    }

    @Override
    public void delete(Integer id) {
        adminRepository.deleteById(id);
    }
}
