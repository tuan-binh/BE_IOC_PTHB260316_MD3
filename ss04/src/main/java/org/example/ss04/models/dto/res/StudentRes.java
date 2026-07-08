package org.example.ss04.models.dto.res;

import org.springframework.beans.factory.annotation.Value;

public interface StudentRes {
    @Value("#{target.fullName + ' - ' + target.age}")
    @SuppressWarnings("SpELInspection")
    String getFullInfo();
}
