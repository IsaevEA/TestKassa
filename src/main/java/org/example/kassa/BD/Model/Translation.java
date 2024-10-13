package org.example.kassa.BD.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.kassa.BD.DTO.DtoTransactionCaode;
import org.example.kassa.BD.DTO.TrnsactionDto;
import org.example.kassa.Enum.Curr;
import org.example.kassa.Enum.TranslationStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Data
@Entity
@Table(name = "translations")
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Curr curr;

    private String senderName;
    private String receiverName;
    private Long soursNumber;
    private Long targetNumber;
    private String description;
    @Enumerated(EnumType.STRING)
    private TranslationStatus status;
    @CreatedDate
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "transactions_code")
    private Long transactionsCode;

    @ManyToOne
    @JoinColumn(name = "source_kassa_id", nullable = false)
    private Kassa sourceKassa;

    @ManyToOne
    @JoinColumn(name = "target_kassa_id")
    private Kassa targetKassa;


    public Translation(TrnsactionDto trnsactionDto) {
        this.amount = trnsactionDto.getAmount();
        this.curr = Curr.KGS;
        this.soursNumber = trnsactionDto.getSoursNumber();
        this.targetNumber = trnsactionDto.getTargetNumber();
        this.description = trnsactionDto.getDescription();
        this.status = TranslationStatus.CREATED;
        this.senderName = trnsactionDto.getSenderName();
        this.receiverName = trnsactionDto.getReceiverName();
        this.transactionsCode = generation();



    }
    public Translation(DtoTransactionCaode dtoTransactionCaode) {
        this.transactionsCode = dtoTransactionCaode.getTransactionsCode();
    }
    public Translation() {}

    public Long generation(){
        Random random = new Random();
        return random.nextLong(100000,999999);
    }
}
