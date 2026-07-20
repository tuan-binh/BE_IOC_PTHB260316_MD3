package org.example.demo_ss10.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lessons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String videoUrl;

    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
