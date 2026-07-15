package org.example.ss08.models.dtos.req;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ss08.utils.validations.annotations.FileExtension;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentReq {
    @NotBlank(message = "Họ tên không được để trống")
    private String fullName;

    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @Pattern(regexp = "^(03|05|07|08|09[2|6|8|9])+([0-9]{8})$",message = "Số điện thoại không đúng định dạng việt nam")
    private String phone;

    @FileExtension(allowedExtensions = {".jpg",".png"},message = "File không đúng định dạng")
    private MultipartFile avatarFile;

}
