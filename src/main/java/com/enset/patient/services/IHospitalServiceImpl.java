package com.enset.patient.services;

import com.enset.patient.entities.Consultation;
import com.enset.patient.entities.Medecin;
import com.enset.patient.entities.Patient;
import com.enset.patient.entities.RendezVous;
import com.enset.patient.repository.ConsultationRepository;
import com.enset.patient.repository.MedecinRepository;
import com.enset.patient.repository.PatientRepository;
import com.enset.patient.repository.RendezVousRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository,
                                MedecinRepository medecinRepository,
                                RendezVousRepository rendezVousRepository,
                                ConsultationRepository consultationRepository)
    {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findPatientAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient findPatientByNom(String s) {
        return patientRepository.findByNom(s);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin findMedecinById(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin findMedecintByNom(String s) {
        return medecinRepository.findByNom(s);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
