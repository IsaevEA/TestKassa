package org.example.kassa.BD.DTO;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.kassa.BD.Model.Kassa;
import org.example.kassa.Enum.Curr;

import java.math.BigDecimal;

@Getter
public class TrnsactionDto {
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Curr curr;

    private String senderName;
    private String receiverName;
    private Long soursNumber;
    private Long targetNumber;
    private String description;

    @ManyToOne
    @JoinColumn(name = "source_kassa_id", nullable = false)
    private Kassa sourceKassa;

    @ManyToOne
    @JoinColumn(name = "target_kassa_id")
    private Kassa targetKassa;
}
