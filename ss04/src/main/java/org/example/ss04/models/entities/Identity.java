package org.example.ss04.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "identity") // nếu không viết schema thì mặc định là public
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cccd;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
