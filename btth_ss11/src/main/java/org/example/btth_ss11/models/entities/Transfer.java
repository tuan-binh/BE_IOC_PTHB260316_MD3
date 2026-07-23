package org.example.btth_ss11.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.btth_ss11.models.constants.TransferType;

import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TransferType type;

    private Double amount;

    private LocalDateTime transferDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
