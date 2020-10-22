package com.cardpay.paymentconsole.entity;


import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PaymentCsvEntity {

    @CsvBindByPosition(position = 0)
    private Long orderId;

    @CsvBindByPosition(position = 1)
    private Double amount;

    @CsvBindByPosition(position = 2)
    private String currency;

    @CsvBindByPosition(position = 3)
    private String comment;
}
