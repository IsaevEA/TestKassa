package org.example.kassa.BD.DTO;

import lombok.Getter;
import org.example.kassa.Enum.StatusTransaction;

@Getter
public class DtoTransactionCode {
    private int code;
    private String message;
    private Long transactionsCode;

    public DtoTransactionCode(StatusTransaction message, Long transactionsCode) {
        this.code = message.getCode();
        this.message = message.getMessage();
        this.transactionsCode = transactionsCode;
    }

    public DtoTransactionCode(StatusTransaction message) {
        this.code = message.getCode();
        this.message = message.getMessage();
    }
}
