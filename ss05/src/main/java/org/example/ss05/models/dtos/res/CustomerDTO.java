package org.example.ss05.models.dtos.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerDTO {
    private String name;
    private String email;
    private String address;
    private Boolean gender;
    private Boolean status;
}
