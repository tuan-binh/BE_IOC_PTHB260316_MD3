package org.example.demo_ss10.models.dtos.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse<T> {
    private String message;
    private T data;
    private Integer code;
}
