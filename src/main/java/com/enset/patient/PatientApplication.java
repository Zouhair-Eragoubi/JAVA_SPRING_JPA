package com.enset.patient;

import com.enset.patient.entities.Patient;
import com.enset.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PatientApplication implements CommandLineRunner {
    @Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//patientRepository.save(new Patient(null,"zouhair",new Date(),true,100));
		//patientRepository.save(new Patient(null,"Ahmed",new Date(),true,100));
		//patientRepository.save(new Patient(null,"Chaymaa",new Date(),false,200));
		//System.out.println("********************************************");
		//patientRepository.findAll().forEach(patient -> System.out.println(patient.toString()));
		//System.out.println("********************************************");
		//patientRepository.findById(1L).get().toString();
		//System.out.println("********************************************");
        //patientRepository.findByNomContains("h").forEach(patient -> System.out.println(patient.toString()));
		//System.out.println("********************************************");
        //patientRepository.deleteById(1l);
		//System.out.println("********************************************");

	}
}
