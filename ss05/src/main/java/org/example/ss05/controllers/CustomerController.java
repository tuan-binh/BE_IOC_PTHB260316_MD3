package org.example.ss05.controllers;

import lombok.RequiredArgsConstructor;
import org.example.ss05.models.entities.Customer;
import org.example.ss05.models.services.ICustomerService;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final ICustomerService customerService;


    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(name = "search", defaultValue = "") String search
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
                customerService.findAllByNameAndEmail(search)
        );
    }

    // API gọi thay đổi trạng thái (nhưng nó phục vụ cho cả nếu là true -> false, ngược lại)
    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                customerService.updateStatus(id)
        );
    }

    @GetMapping("/pagination")
    public ResponseEntity<?> findAllPagination(
//            @RequestParam(name = "page",defaultValue = "0") int page,
//            @RequestParam(name = "size",defaultValue = "2") int size,
//            @RequestParam(name = "sort",defaultValue = "id") String sort,
//            @RequestParam(name = "direction",defaultValue = "ASC") String direction,
            @PageableDefault(
                    page = 0,
                    size = 2,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable,
            @RequestParam(name = "search",defaultValue = "") String search
    ) {

//        Sort sortDirection;
//        if(direction.equals("ASC")) {
//            sortDirection = Sort.by(Sort.Direction.ASC,sort);
//        } else {
//            sortDirection = Sort.by(Sort.Direction.DESC,sort);
//        }
//        Pageable pageable = PageRequest.of(page, size,sortDirection);
        Page<Customer> customers = customerService.findAllAndPagination(pageable,search);

        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @GetMapping("/get-males")
    public ResponseEntity<?> getMales() {
        return ResponseEntity.status(HttpStatus.OK).body(
            customerService.findAllCustomerIsMale()
        );
    }

    @GetMapping("/class-dto")
    public ResponseEntity<?> getClassDto() {
        return ResponseEntity.status(HttpStatus.OK).body(
                customerService.findAllWithDTO()
        );
    }

}
