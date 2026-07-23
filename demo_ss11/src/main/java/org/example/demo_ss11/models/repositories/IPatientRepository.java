package org.example.demo_ss11.models.repositories;

import org.example.demo_ss11.models.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPatientRepository extends JpaRepository<Patient,Long> {
}
