package org.example.kassa.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum StatusTransaction {
    PAYMENT_SUCCESSFUL(250, "Платеж успешно выдан"),
    TRANSACTION_NOT_FOUNT(400, "Платеж не найден"),
    KASSA_NOT_FOUND(404,"Касса не найдена"),
    NOT_ENOUGH_BALANCE(424, "Недостаточно средств"),
    TRANSACTION_SUCCESSFUL(200,"Платеж отправлен"),
    TRANSACTION_CLOSED(444, "Платеж закрыт");




    private final int code;
    private final String message;

}
