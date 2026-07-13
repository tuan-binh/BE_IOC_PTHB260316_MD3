package org.example.chua_bai_ss06.models.repositories;

import org.example.chua_bai_ss06.models.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IZoneRepostirory extends JpaRepository<Zone,Long> {
}
