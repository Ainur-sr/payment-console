package com.cardpay.paymentconsole.service;

import com.cardpay.paymentconsole.domain.Payment;
import com.cardpay.paymentconsole.entity.PaymentCsvEntity;
import com.cardpay.paymentconsole.mapper.PaymentMapper;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentCsvServiceImpl implements PaymentCsvService {

    private final PaymentMapper paymentMapper;

    @Override
    public List<Payment> getPaymentList(File file) throws IOException {
        CsvToBeanBuilder<PaymentCsvEntity> csvToBeanBuilder
                = new CsvToBeanBuilder<PaymentCsvEntity>(new FileReader(file));
        List<PaymentCsvEntity> paymentCSVEntities = csvToBeanBuilder.withType(PaymentCsvEntity.class).build().parse();
        return paymentMapper.toDomainFromCSV(paymentCSVEntities, file.getName());
    }
}
