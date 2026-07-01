package org.example.chua_bai_ss01.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // constructor không tham số
@AllArgsConstructor // constructor đầy đủ tham số
@Getter // sinh ra các getter tương ứng với thuộc tính
@Setter // sinh ra các setter tương ứng với thuộc tính
public class Product {
    private Integer id;
    private String name;
    private Double price;
}
