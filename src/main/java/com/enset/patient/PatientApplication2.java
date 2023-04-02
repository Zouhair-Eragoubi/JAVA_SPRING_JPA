package com.enset.patient;

import com.enset.patient.entities.*;
import com.enset.patient.repository.ConsultationRepository;
import com.enset.patient.repository.MedecinRepository;
import com.enset.patient.repository.PatientRepository;
import com.enset.patient.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientApplication2{

    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PatientRepository patientRepository
            ,MedecinRepository medecinRepository
            , RendezVousRepository rendezVousRepository
            , ConsultationRepository consultationRepository){
        return args -> {
            Stream.of("Zouhair","Ahmed","Chaymaa").forEach(name ->{
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                patient.setScore(100);
                patientRepository.save(patient);
            });

            System.out.println("********************************************");
            Stream.of("Ayoub","Fatma","Chaymaa").forEach(name ->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Général":"Cardio");
                medecinRepository.save(medecin);
            });
            System.out.println("********************************************");
            Patient patient = patientRepository.findById(1L).orElse(null);
            System.out.println(patient);

            System.out.println("********************************************");
            Patient patient1 = patientRepository.findByNom("Zouhair");
            System.out.println(patient1);

            System.out.println("********************************************");
            Medecin medecin = medecinRepository.findByNom("Ayoub");
            System.out.println(medecin);

            System.out.println("********************************************");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient1);
            rendezVous.setMedecin(medecin);
            rendezVousRepository.save(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).get();

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRapport("tous sont bien");
            consultation.setRendezVous(rendezVous1);
            consultationRepository.save(consultation);


        };
    }
}
