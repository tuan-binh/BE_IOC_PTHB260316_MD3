package org.example.demo_ss11.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.demo_ss11.models.dtos.req.PatientReq;
import org.example.demo_ss11.models.entities.Patient;
import org.example.demo_ss11.models.services.IPatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {
    private final IPatientService patientService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> addNewPatient(@Valid @RequestBody PatientReq req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.addNewPatient(req));
    }

}
