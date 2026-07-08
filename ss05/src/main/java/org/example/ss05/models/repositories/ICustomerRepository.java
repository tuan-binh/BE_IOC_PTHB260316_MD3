package org.example.ss05.models.repositories;

import org.example.ss05.models.dtos.res.CustomerDTO;
import org.example.ss05.models.dtos.res.CustomerRes;
import org.example.ss05.models.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByNameContainsOrEmailContains(String name, String email);

    // JPQL
    @Query("""
                    SELECT c FROM Customer c
                            WHERE c.name LIKE %:search%
                            OR c.email LIKE %:search%
            """)
    List<Customer> searchNameAndEmailContains(@Param("search") String search);

    @Query("""
                    SELECT c FROM Customer c
                            WHERE c.name LIKE %:search%
                            OR c.email LIKE %:search%
            """)
    Page<Customer> searchNameAndEmailWithPagination(@Param("search") String search, Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.status = (NOT c.status) WHERE c.id = :id")
    void updateStatus(@Param("id") Long id);

    // Lấy danh sách khách hàng là nam (gender = true)
    List<CustomerRes> findAllByGenderIsTrue();

    @Query("""
        SELECT new org.example.ss05.models.dtos.res.CustomerDTO(
                concat('Xin chào ',c.name),
                c.email,
                c.address,
                c.gender,
                c.status
            ) FROM Customer c
    """)
    List<CustomerDTO> searchAll();

}
