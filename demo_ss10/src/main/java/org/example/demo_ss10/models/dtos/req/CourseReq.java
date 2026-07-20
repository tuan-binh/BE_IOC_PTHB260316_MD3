package org.example.demo_ss10.models.dtos.req;

import jakarta.persistence.EnumType;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo_ss10.models.constants.CourseStatus;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CourseReq {
    @NotBlank(message = "code không được để trống")
    @Size(min = 4,max = 10,message = "code phải có độ dài từ 4 đến 10 ký tự")
    private String code;

    @NotBlank(message = "title không được để trống")
    @Length(max = 150,message = "title tối đa 150 ký tự")
    private String title;

    private String description;

    @NotNull(message = "price không được để trống")
    @Min(value = 0,message = "price phải lớn hơn hoặc bằng 0")
    private Double price;

    @NotNull(message = "status không được để trống")
    private CourseStatus status;
}
