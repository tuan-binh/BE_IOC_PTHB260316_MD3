package org.example.chua_bai_ss06.models.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.chua_bai_ss06.models.dto.res.TicketSummaryResponse;
import org.example.chua_bai_ss06.models.repositories.IParkingTicketRepository;
import org.example.chua_bai_ss06.models.services.IParkingTicketService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingTicketServiceImpl implements IParkingTicketService {
    private final IParkingTicketRepository parkingTicketRepository;

    @Override
    public List<TicketSummaryResponse> getTicketSummary() {
        // thời gian ngày tháng năm thì dùng now thời gian thì set lại start = 0 end = 24
        LocalDate today = LocalDate.now();
        LocalDateTime start = LocalDateTime.of(
                today.getYear(),
                today.getMonth(),
                today.getDayOfMonth(),
                0,
                0,
                0
        );

        LocalDateTime end = LocalDateTime.of(
                today.getYear(),
                today.getMonth(),
                today.getDayOfMonth(),
                23,
                59,
                59
        );

        return parkingTicketRepository.summaryTicketToday(start, end);
    }
}
