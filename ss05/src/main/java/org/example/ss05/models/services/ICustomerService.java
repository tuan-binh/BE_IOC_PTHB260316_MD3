package org.example.ss05.models.services;

import org.example.ss05.models.dtos.res.CustomerDTO;
import org.example.ss05.models.dtos.res.CustomerRes;
import org.example.ss05.models.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllByNameAndEmail(String search);

    Customer updateStatus(Long id);

    Page<Customer> findAllAndPagination(Pageable pageable, String search);

    Slice<Customer> findAllWithSlice(Pageable pageable);

    List<CustomerRes> findAllCustomerIsMale();

    List<CustomerDTO> findAllWithDTO();
}
