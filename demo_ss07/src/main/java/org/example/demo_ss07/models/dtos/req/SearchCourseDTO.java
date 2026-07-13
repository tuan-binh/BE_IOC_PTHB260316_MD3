package org.example.demo_ss07.models.dtos.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SearchCourseDTO {
    private String title;
    private Double minPrice;
    private Double maxPrice;
}
