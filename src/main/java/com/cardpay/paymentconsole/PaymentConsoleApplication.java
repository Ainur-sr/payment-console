package com.cardpay.paymentconsole;

import com.cardpay.paymentconsole.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentConsoleApplication implements CommandLineRunner {

	private final PaymentService paymentService;

	public static void main(String[] args) {
		SpringApplication.run(PaymentConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		paymentService.parseFiles(args);
	}
}
