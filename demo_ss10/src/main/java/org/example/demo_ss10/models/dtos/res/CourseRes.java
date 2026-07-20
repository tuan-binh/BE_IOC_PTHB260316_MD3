package org.example.demo_ss10.models.dtos.res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo_ss10.models.constants.CourseStatus;
import org.example.demo_ss10.models.entities.Lesson;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CourseRes {
    private Long id;

    private String code;

    private String title;

    private String description;

    private Double price;

    private CourseStatus status;

    @JsonIgnoreProperties({"course"})
    private List<Lesson> lessons;
}
