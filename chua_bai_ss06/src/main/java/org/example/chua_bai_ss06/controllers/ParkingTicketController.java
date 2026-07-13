package org.example.chua_bai_ss06.controllers;

import lombok.RequiredArgsConstructor;
import org.example.chua_bai_ss06.models.dto.res.TicketSummaryResponse;
import org.example.chua_bai_ss06.models.services.IParkingTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class ParkingTicketController {
    private final IParkingTicketService parkingTicketService;

    @GetMapping
    public ResponseEntity<?> getTicketSummary() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(parkingTicketService.getTicketSummary());
    }

}
