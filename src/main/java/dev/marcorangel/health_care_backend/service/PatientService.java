package dev.marcorangel.health_care_backend.service;

import dev.marcorangel.health_care_backend.model.Patient;
import dev.marcorangel.health_care_backend.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient register(Patient patientCreate) {
        return patientRepository.save(Patient.builder()
                .patient_name(patientCreate.getPatient_name())
                .patient_email(patientCreate.getPatient_email())
                .patient_mobile(patientCreate.getPatient_mobile())
                .registeredDate(new Date())
                .build());
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatient(String patient_id) {
        Optional<Patient> patient = patientRepository.findById(patient_id);
        return patient.orElseGet(patient::get);
    }

    public void delete(String patient_id) {
        patientRepository.deleteById(patient_id);
    }
}