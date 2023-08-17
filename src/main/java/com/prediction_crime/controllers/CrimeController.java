package com.prediction_crime.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prediction_crime.dto.CrimeDto;
import com.prediction_crime.entities.CrimeEntity;
import com.prediction_crime.services.CrimeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/crimes")
public class CrimeController {

    private CrimeService crimeService;
  
    public CrimeController(CrimeService crimeService){
        this.crimeService = crimeService;
    }

    @PostMapping("")
    public ResponseEntity<CrimeDto> addCrime(@Valid  @RequestBody() CrimeDto crimeDto){
        CrimeDto crime = crimeService.save(crimeDto);
        return new ResponseEntity<>(crime, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<CrimeDto>> getAllCrimes(){
        List<CrimeDto> crime = crimeService.findAll();
        return new ResponseEntity<>(crime, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CrimeDto> getCrimeById(@PathVariable("id") Long id){
        CrimeDto crime = crimeService.findById(id);
        return new ResponseEntity<>(crime, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CrimeDto>> getCrimesByName(@PathVariable("name") String name){
        List<CrimeDto> crime =  crimeService.findByName(name);
        return new ResponseEntity<>(crime, HttpStatus.OK);
    }

    @GetMapping("/place/{place}")
    public ResponseEntity<List<CrimeDto>> getCrimesByPlace(@PathVariable("place") String place){
        return new ResponseEntity<>(crimeService.findByPlace(place), HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<CrimeDto>> getCrimesByType(@PathVariable("type") String type){
        return new ResponseEntity<>(crimeService.findByType(type), HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<CrimeDto>> getCrimesByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        List<CrimeDto> crime =  crimeService.findByDate(date);
        return new ResponseEntity<>(crime, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<CrimeDto> updateCrime(@Valid @RequestBody() CrimeDto crimeDto, @PathVariable Long id) {
        return ResponseEntity.accepted().body(crimeService.update(crimeDto, id));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteCrime(@PathVariable Long id) {
        crimeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
