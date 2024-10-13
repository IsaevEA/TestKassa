package org.example.kassa.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum StatusTransaction {
    PAYMENT_SUCCESSFUL(250, "Платеж успешно выдана"),
    TRANSACTION_NOT_FOUNT(400, "Платеж нет найден"),
    TRANSACTION_CLOSED(421, "Платеж закрыт");

    private final int code;
    private final String message;

}
