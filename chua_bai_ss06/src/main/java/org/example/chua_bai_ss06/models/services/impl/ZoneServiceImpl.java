package org.example.chua_bai_ss06.models.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.chua_bai_ss06.models.dto.req.ZoneReq;
import org.example.chua_bai_ss06.models.entities.Zone;
import org.example.chua_bai_ss06.models.repositories.IZoneRepostirory;
import org.example.chua_bai_ss06.models.services.IZoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements IZoneService {
    private final IZoneRepostirory zoneRepostirory;

    @Override
    public List<Zone> findAll() {
        return zoneRepostirory.findAll();
    }

    @Override
    public Zone addNewZone(ZoneReq req) {

        Zone zone = Zone.builder()
                .name(req.getName())
                .build();

        return zoneRepostirory.save(zone);
    }
}
