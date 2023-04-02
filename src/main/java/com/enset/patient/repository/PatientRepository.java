package com.enset.patient.repository;

import com.enset.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {


    List<Patient> findByNomContains(String mc);
    Patient findByNom(String nom);
}
