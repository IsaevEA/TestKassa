package org.example.kassa.BD.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import org.example.kassa.Enum.Curr;

import java.math.BigDecimal;

@Getter
public class TrnsactionDto {
    private BigDecimal amount;



    private String senderName;
    private String receiverName;
    private Long soursNumber;
    private Long targetNumber;
    private String description;
}
