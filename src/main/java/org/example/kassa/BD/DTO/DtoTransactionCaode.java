package org.example.kassa.BD.DTO;

import lombok.Getter;
import org.example.kassa.Enum.StatusTransaction;

import java.util.UUID;
@Getter
public class DtoTransactionCaode {
    private int code;
    private String message;
    private Long transactionsCode;

    public DtoTransactionCaode( StatusTransaction message, Long transactionsCode) {
        this.code = message.getCode();
        this.message = message.getMessage();
        this.transactionsCode = transactionsCode;
    }

    public DtoTransactionCaode( StatusTransaction message) {
        this.code = message.getCode();
        this.message = message.getMessage();
    }
}
