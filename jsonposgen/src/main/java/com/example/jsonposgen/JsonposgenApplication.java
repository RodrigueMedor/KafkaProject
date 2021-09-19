package com.example.jsonposgen;

import com.example.jsonposgen.service.KafkaProducerService;
import com.example.jsonposgen.service.generator.InvoiceGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
@RequiredArgsConstructor
public class JsonposgenApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(JsonposgenApplication.class, args);
    }

    private final KafkaProducerService producerService;
    private final InvoiceGenerator invoiceGenerator;

    @Value("${application.configs.invoice.count}")
    private int INVOICE_COUNT;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for(int i = 0; i < INVOICE_COUNT; i++){
            producerService.sendMessage(invoiceGenerator.getNextInvoice());
            Thread.sleep(1000);
        }
    }
}
