package org.example.ss04.models.repositories;

import org.example.ss04.models.entities.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IClassesRepository extends JpaRepository<Classes,Long> {
}
