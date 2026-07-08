package org.example.ss05.models.dtos.res;

import org.springframework.beans.factory.annotation.Value;

public interface CustomerRes {
    String getName();
    String getEmail();

    @Value("#{target.name +' - '+target.address}")
    String getFullInfo();
}
