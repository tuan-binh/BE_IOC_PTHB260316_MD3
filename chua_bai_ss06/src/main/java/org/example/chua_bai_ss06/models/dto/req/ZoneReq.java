package org.example.chua_bai_ss06.models.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ZoneReq {

    @NotBlank(message = "Tên khu vực gửi xe ko được để trống")
    private String name;

}
