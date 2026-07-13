package org.example.chua_bai_ss06.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "zones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
