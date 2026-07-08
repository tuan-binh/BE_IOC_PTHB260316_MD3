package org.example.ss05.models.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.ss05.models.dtos.res.CustomerDTO;
import org.example.ss05.models.dtos.res.CustomerRes;
import org.example.ss05.models.entities.Customer;
import org.example.ss05.models.repositories.ICustomerRepository;
import org.example.ss05.models.services.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    /*
        API tìm kiếm theo tên và email (tìm kiến tương đối)
    */

    private final ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAllByNameAndEmail(String search) {
        if(search.isEmpty()) {
            return customerRepository.findAll();
        }
        return customerRepository.searchNameAndEmailContains(search);
    }

    // cách logic ko sql
    // tìm kiếm
    // thay đổi trạng thái cách phủ định !
    // lưu

    // cách tự viết SQL
    @Override
    public Customer updateStatus(Long id) {
        customerRepository.updateStatus(id);
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with id " + id + " does not exist"));
    }

    @Override
    public Page<Customer> findAllAndPagination(Pageable pageable,String search) {
        if(search.isEmpty()) {
            return customerRepository.findAll(pageable);
        }
        return customerRepository.searchNameAndEmailWithPagination(search,pageable);
    }

    @Override
    public Slice<Customer> findAllWithSlice(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<CustomerRes> findAllCustomerIsMale() {
        return customerRepository.findAllByGenderIsTrue();
    }

    @Override
    public List<CustomerDTO> findAllWithDTO() {
        return customerRepository.searchAll();
    }
}
