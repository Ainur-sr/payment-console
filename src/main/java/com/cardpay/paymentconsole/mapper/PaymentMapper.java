package com.cardpay.paymentconsole.mapper;

import com.cardpay.paymentconsole.domain.Payment;
import com.cardpay.paymentconsole.entity.PaymentCsvEntity;
import com.cardpay.paymentconsole.entity.PaymentJsonEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentMapper {

    public List<Payment> toDomainFromCSV(List<PaymentCsvEntity> paymentCSVEntities, String fileName) {
        List<Payment> resultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(paymentCSVEntities)) {
            for (int i = 0; i < paymentCSVEntities.size(); i++) {
                Payment payment = new Payment();
                payment
                        .setOrderId(paymentCSVEntities.get(i).getOrderId())
                        .setAmount(paymentCSVEntities.get(i).getAmount())
                        .setCurrency(paymentCSVEntities.get(i).getCurrency())
                        .setComment(paymentCSVEntities.get(i).getComment())
                        .setLine((long) i + 1)
                        .setFileName(fileName)
                        .setResult("OK");
                resultList.add(payment);
            }
        }

        return resultList;
    }

    public List<Payment> toDomainFromJSON(List<PaymentJsonEntity> paymentEntities, String fileName) {
        List<Payment> resultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(paymentEntities)) {
            for (int i = 0; i < paymentEntities.size(); i++) {
                Payment payment = new Payment();
                payment
                        .setOrderId(paymentEntities.get(i).getOrderId())
                        .setAmount(paymentEntities.get(i).getAmount())
                        .setCurrency(paymentEntities.get(i).getCurrency())
                        .setComment(paymentEntities.get(i).getComment())
                        .setLine((long) i + 1)
                        .setFileName(fileName)
                        .setResult("OK");
                resultList.add(payment);
            }
        }

        return resultList;
    }
}
