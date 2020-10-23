package com.cardpay.paymentconsole.service;

import com.cardpay.paymentconsole.domain.Payment;
import com.cardpay.paymentconsole.entity.PaymentJsonEntity;
import com.cardpay.paymentconsole.mapper.PaymentMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentJsonServiceImpl implements PaymentJsonService {

    private final PaymentMapper paymentMapper;

    @Override
    public List<Payment> getPaymentList(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<PaymentJsonEntity> paymentEntities = objectMapper.readValue(new FileReader(file),
                new TypeReference<List<PaymentJsonEntity>>() {
                });
        return paymentMapper.toDomainFromJSON(paymentEntities, file.getName());
    }
}
