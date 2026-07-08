package org.example.ss05.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder // builder là khởi tạo đối tượng những dưới dạng giống stream API (.)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private Boolean gender;
    private Boolean status;
}
