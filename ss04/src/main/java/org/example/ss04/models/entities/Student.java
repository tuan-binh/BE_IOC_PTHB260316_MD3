package org.example.ss04.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "students",schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name",length = 100)
    private String fullName;

    @JsonIgnore // bỏ qua thông tin khi trả về dữ liệu
    @Column(name = "age")
    private Integer age;

    @JsonIgnoreProperties({"id"})
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;

    @ManyToMany
    @JoinTable(
            name = "student_role", // tên bảng
            joinColumns = @JoinColumn(name = "student_id"), // khóa ngoại tham chiếu đến thực thể chính nó
            inverseJoinColumns = @JoinColumn(name = "role_id") // bên ngược lại
    )
    private Set<Role> roles;

}
