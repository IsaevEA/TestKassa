package org.example.kassa.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum StatusTransaction {
    PAYMENT_SUCCESSFUL(250, "Платеж успешно выдана"),
    TRANSACTION_NOT_FOUNT(400, "Платеж не найден"),
    TRANSACTION_CLOSED(421, "Платеж закрыт"),
    TRANSACTION_SUCCESSFUL(200, "Платеж успешно отправлен");


    private final int code;
    private final String message;

}
