package com.cardpay.paymentconsole.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PaymentJsonEntity {

    private Long orderId;

    private Double amount;

    private String currency;

    private String comment;
}
