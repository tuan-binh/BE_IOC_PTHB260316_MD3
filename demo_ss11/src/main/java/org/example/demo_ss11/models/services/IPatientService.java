package org.example.demo_ss11.models.services;

import org.example.demo_ss11.models.dtos.req.PatientReq;
import org.example.demo_ss11.models.entities.Patient;

import java.util.List;

public interface IPatientService {

    List<Patient> findAll();

    Patient addNewPatient(PatientReq req);

}
