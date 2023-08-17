package com.prediction_crime;

import com.prediction_crime.dto.CrimeDto;
import com.prediction_crime.services.CrimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrimeTest {

    private static final long serialVersionUID = 2942565129149668126L;


    @Autowired
    private CrimeService crimeService;

    @Test
    public void shouldCrimeSaveWithSuccess() {

        final CrimeDto expectedCrime = new CrimeDto();
        expectedCrime.setName("crimeName test");
        expectedCrime.setType("crimeType test");
        expectedCrime.setPlace("crimePlace test");
        expectedCrime.setDate(LocalDate.now());


        CrimeDto savedCrime = crimeService.save(expectedCrime);

        assertNotNull(savedCrime);
        assertNotNull(savedCrime.getId());
        assertEquals(expectedCrime.getName(), savedCrime.getName());
        assertEquals(expectedCrime.getType(), savedCrime.getType());
        assertEquals(expectedCrime.getPlace(), savedCrime.getPlace());
        assertEquals(expectedCrime.getDate(), savedCrime.getDate());
    }

}
