package org.example.demo_ss07.models.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "course_code")
    private String courseCode;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;

    @Column(name = "duration_hours")
    private Integer durationHours;

    @Column(name = "instructor_email")
    private String instructorEmail;
}
