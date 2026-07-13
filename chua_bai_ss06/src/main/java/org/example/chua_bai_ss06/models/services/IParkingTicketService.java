package org.example.chua_bai_ss06.models.services;

import org.example.chua_bai_ss06.models.dto.res.TicketSummaryResponse;

import java.util.List;

public interface IParkingTicketService {

    List<TicketSummaryResponse> getTicketSummary();

}
