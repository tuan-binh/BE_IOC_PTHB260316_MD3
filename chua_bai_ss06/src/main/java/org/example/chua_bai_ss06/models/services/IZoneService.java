package org.example.chua_bai_ss06.models.services;

import org.example.chua_bai_ss06.models.dto.req.ZoneReq;
import org.example.chua_bai_ss06.models.entities.Zone;

import java.util.List;

public interface IZoneService {

    List<Zone> findAll();

    Zone addNewZone(ZoneReq req);

}
