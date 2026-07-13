package org.example.chua_bai_ss06.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.chua_bai_ss06.models.dto.req.ZoneReq;
import org.example.chua_bai_ss06.models.dto.wrapper.ApiResponse;
import org.example.chua_bai_ss06.models.services.IZoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/zones")
@RequiredArgsConstructor
public class ZoneController {
    private final IZoneService zoneService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(zoneService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> addNewZone(
            @Valid @ModelAttribute ZoneReq req,
            BindingResult result
    ) {
        if(result.hasErrors()) {
            /*
                {
                    "field" : "message"
                }
            */

            Map<String, String> errors = new HashMap<>();

            result.getFieldErrors().forEach(
                    err -> errors.put(err.getField(),err.getDefaultMessage())
            );

            return ResponseEntity.badRequest().body(
                    ApiResponse.builder()
                            .status("FAILED")
                            .message("Zone Add Failed")
                            .data(errors)
                            .build()
            );
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status("SUCCESS")
                                .message("Zone created successfully")
                                .data(zoneService.addNewZone(req))
                                .build()
                );
    }

}
