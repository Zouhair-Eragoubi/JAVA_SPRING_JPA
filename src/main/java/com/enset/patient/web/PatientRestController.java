package com.enset.patient.web;

import com.enset.patient.entities.Patient;
import com.enset.patient.repository.PatientRepository;
import com.enset.patient.services.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private IHospitalService hospitalService;

    @GetMapping("/patients")
    public List<Patient> patients(){
        return hospitalService.findPatientAll();
    }
}
