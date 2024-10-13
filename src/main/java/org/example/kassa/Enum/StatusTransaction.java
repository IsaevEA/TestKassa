package org.example.kassa.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum StatusTransaction {
    PAYMENT_SUCCESSFUL(250, "Платеж успешно выдан"),
    TRANSACTION_NOT_FOUNT(400, "Платеж нет найден");

    private final int code;
    private final String message;

}
