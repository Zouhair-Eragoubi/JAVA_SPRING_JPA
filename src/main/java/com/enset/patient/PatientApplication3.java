package com.enset.patient;

import com.enset.patient.entities.*;
import com.enset.patient.repository.ConsultationRepository;
import com.enset.patient.repository.MedecinRepository;
import com.enset.patient.repository.PatientRepository;
import com.enset.patient.repository.RendezVousRepository;
import com.enset.patient.services.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientApplication3{

    public static void main(String[] args) {
        
        SpringApplication.run(PatientApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService iHospitalService){
        return args -> {
            Stream.of("Zouhair","Ahmed","Chaymaa").forEach(name ->{
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                patient.setScore(100);
                iHospitalService.savePatient(patient);
            });

            System.out.println("********************************************");
            Stream.of("Ayoub","Fatma","Chaymaa").forEach(name ->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Général":"Cardio");
                iHospitalService.saveMedecin(medecin);
            });
            System.out.println("********************************************");
            Patient patient = iHospitalService.findPatientById(1L);

            System.out.println("********************************************");
            Patient patient1 = iHospitalService.findPatientByNom("Zouhair");


            System.out.println("********************************************");
            Medecin medecin = iHospitalService.findMedecintByNom("Ayoub");

            System.out.println("********************************************");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient1);
            rendezVous.setMedecin(medecin);
            RendezVous rendezVous1= iHospitalService.saveRendezVous(rendezVous);


            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRapport("tous sont bien");
            consultation.setRendezVous(rendezVous1);
            iHospitalService.saveConsultation(consultation);


        };
    }
}
