package org.example.chua_bai_ss01.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
    private Integer id;
    private String title;
    private String description;
    private String priority;
    private Integer assignedTo;
}
