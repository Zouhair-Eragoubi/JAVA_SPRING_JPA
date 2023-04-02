package com.enset.patient.services;

import com.enset.patient.entities.Consultation;
import com.enset.patient.entities.Medecin;
import com.enset.patient.entities.Patient;
import com.enset.patient.entities.RendezVous;

import java.util.List;

public interface IHospitalService {

    Patient savePatient(Patient patient);
    List<Patient> findPatientAll();
    Patient findPatientById(Long id);
    Patient findPatientByNom(String s);
    Medecin saveMedecin(Medecin medecin);
    Medecin findMedecinById(Long id);
    Medecin findMedecintByNom(String s);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
