package com.prediction_crime.controllers;

import com.prediction_crime.dto.CrimeDto;
import com.prediction_crime.dto.VictimDto;
import com.prediction_crime.services.VictimService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/victims")
public class VictimController {

    private final VictimService victimService;

    public VictimController(VictimService victimService) {
        this.victimService = victimService;
    }

    @PostMapping("")
    public ResponseEntity<VictimDto> addVictim(@Valid @RequestBody() VictimDto victimDto){
        VictimDto victim = victimService.save(victimDto);
        return new ResponseEntity<>(victim, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<VictimDto>> getAllVictims(){
        List<VictimDto> victim = victimService.findAll();
        return new ResponseEntity<>(victim, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<VictimDto> getVictimById(@PathVariable("id") Long id){
        VictimDto victim = victimService.findById(id);
        return new ResponseEntity<>(victim, HttpStatus.OK);
    }

    @GetMapping("/firstname/{firstName}/lastname/{lastName}")
    public ResponseEntity<List<VictimDto>> getVictimsByNameComplet(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        List<VictimDto> victim = victimService.findByFirstNameAndLastName(firstName, lastName);
        return new ResponseEntity<>(victim, HttpStatus.OK);
    }

    @GetMapping("/age/{age}}")
    public ResponseEntity<List<VictimDto>> getVictimsByAge(@PathVariable("age") Integer age){
        List<VictimDto> victim = victimService.findByAge(age);
        return new ResponseEntity<>(victim, HttpStatus.OK);
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<VictimDto>> getVictimsByGender(@PathVariable("gender") String gender){
        List<VictimDto> victim = victimService.findByGender(gender);
        return new ResponseEntity<>(victim, HttpStatus.OK);
    }

    @GetMapping("/address/{address}")
    public ResponseEntity<List<VictimDto>> getVictimsByAddress(@PathVariable("address") String address){
        List<VictimDto> victim = victimService.findByAddress(address);
        return new ResponseEntity<>(victim, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<VictimDto> updateVictim(@Valid @RequestBody() VictimDto victimDto, @PathVariable Long id) {
        return ResponseEntity.accepted().body(victimService.update(victimDto, id));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteCrime(@PathVariable Long id) {
        victimService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
