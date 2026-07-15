package org.example.ss08.utils.validations.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.ss08.utils.validations.handle.FileExtensionValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FileExtensionValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FileExtension {
    String message() default "Invalid file extension";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String[] allowedExtensions() default {".jpg",".png",".jpeg"};

}
