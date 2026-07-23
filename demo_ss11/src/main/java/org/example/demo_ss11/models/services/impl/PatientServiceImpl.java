package org.example.demo_ss11.models.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo_ss11.models.dtos.req.PatientReq;
import org.example.demo_ss11.models.entities.Patient;
import org.example.demo_ss11.models.repositories.IPatientRepository;
import org.example.demo_ss11.models.services.IPatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements IPatientService {
    private final IPatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient addNewPatient(PatientReq req) {
        log.info("Adding new patient {}", req);
        return patientRepository.save(
                Patient.builder()
                        .fullName(req.getFullName())
                        .phone(req.getPhone())
                        .address(req.getAddress())
                        .build()
        );
    }
}
