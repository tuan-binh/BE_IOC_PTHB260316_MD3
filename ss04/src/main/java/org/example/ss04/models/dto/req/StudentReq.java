package org.example.ss04.models.dto.req;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentReq {
    private String fullName;

    private Integer age;

    private Long classId;
}
