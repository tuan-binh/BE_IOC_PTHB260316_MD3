package org.example.chua_bai_ss06.models.repositories;

import org.example.chua_bai_ss06.models.dto.res.TicketSummaryResponse;
import org.example.chua_bai_ss06.models.entities.ParkingTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IParkingTicketRepository extends JpaRepository<ParkingTicket, Long> {

    @Query("""
            SELECT new org.example.chua_bai_ss06.models.dto.res.TicketSummaryResponse(
                        pt.id,
                        pt.vehicle.licensePlate,
                        pt.zone.name,
                        pt.checkInTime,
                        pt.checkOutTime
                        ) FROM ParkingTicket pt
            WHERE pt.checkInTime >= :start AND pt.checkOutTime <= :end
            """)
    List<TicketSummaryResponse> summaryTicketToday(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

}
