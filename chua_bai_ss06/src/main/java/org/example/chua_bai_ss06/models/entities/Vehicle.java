package org.example.chua_bai_ss06.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.chua_bai_ss06.models.constants.VehicleType;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_plate")
    private String licensePlate;

    private String color;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

}
