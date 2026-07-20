package org.example.demo_ss10.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.demo_ss10.models.constants.CourseStatus;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code",unique = true)
    private String code;

    @Column(name = "title",length = 150)
    private String title;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CourseStatus status;
}
