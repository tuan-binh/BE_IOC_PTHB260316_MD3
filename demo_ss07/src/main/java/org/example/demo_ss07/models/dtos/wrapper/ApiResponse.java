package org.example.demo_ss07.models.dtos.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
}
