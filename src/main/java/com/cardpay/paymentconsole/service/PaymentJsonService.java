package com.cardpay.paymentconsole.service;

import com.cardpay.paymentconsole.domain.Payment;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface PaymentJsonService {
    List<Payment> getPaymentList(File file) throws IOException;
}
