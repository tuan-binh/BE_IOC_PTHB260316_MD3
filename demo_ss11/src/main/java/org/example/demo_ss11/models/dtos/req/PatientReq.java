package org.example.demo_ss11.models.dtos.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PatientReq {
    @NotBlank(message = "full name không được để trống")
    private String fullName;
    @NotBlank(message = "phone không được để trống")
    private String phone;
    @NotBlank(message = "address không được để trống")
    private String address;
}
