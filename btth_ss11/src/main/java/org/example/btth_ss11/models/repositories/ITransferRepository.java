package org.example.btth_ss11.models.repositories;

import org.example.btth_ss11.models.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferRepository extends JpaRepository<Transfer,Long> {
}
