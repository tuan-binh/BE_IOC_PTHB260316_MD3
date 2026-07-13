package org.example.demo_ss07.models.dtos.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CourseRequestDTO {

    @NotBlank(message = "Mã khóa học không được để trống")
    @Pattern(regexp = "^KH-\\d{4}$",message = "Vui lòng nhập đúng định dạng KH-XXXX")
    private String courseCode;

    @NotBlank(message = "Tên khóa học không được để trống")
    @Size(min = 10,max = 150,message = "Tối thiếu 10 và tối đa là 150 ký tự")
    private String title;

    private String description;

    @PositiveOrZero(message = "Vui lòng nhập giá lớn hơn hoặc bằng 0")
    private Double price;

    @Positive(message = "Vui lòng nhập số nguyên dương")
    private Integer durationHours;

    @NotBlank(message = "Địa chỉ email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String instructorEmail;
}
