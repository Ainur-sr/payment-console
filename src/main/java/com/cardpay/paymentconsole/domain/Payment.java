package com.cardpay.paymentconsole.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Payment {

    /**
     * идентификатор ордера
     */
    private Long orderId;

    /**
     * сумма ордера
     */
    private Double amount;

    /**
     * валюта суммы ордера
     */
    private String currency;

    /**
     * комментарий по ордеру
     */
    private String comment;

    /**
     * номер строки исходного файла
     */
    private Long line;

    /**
     * Имя исходного файла
     */
    private String fileName;

    /**
     * результат парсинга записи исходного файла
     */
    private String result;

    @Override
    public String toString() {
        return "{\"orderId\": " + orderId +
                ", \"amount\": " + amount +
                ", \"currency\": \"" + currency + '\"' +
                ", \"comment\": \"" + comment + '\"' +
                ", \"line\": " + line +
                ", \"fileName\": \"" + fileName + '\"' +
                ", \"result\": \"" + result + '\"' +
                '}';
    }
}
