package com.kafkaStreamAvroProject.services;

import com.kafkaStreamAvroProject.model.PosInvoice;
import org.springframework.stereotype.Service;

@Service
public class RecordBuilder {


    public Notification getNotification(PosInvoice invoice){
        Notification notification = new Notification();
        notification.setInvoiceNumber(invoice.getInvoiceNumber());
        notification.setCustomerCardNo(invoice.getCustomerCardNo());
        notification.setTotalAmount(invoice.getTotalAmount());
        notification.setEarnedLoyaltyPoints(invoice.getTotalAmount() * 0.02);
        return notification;
    }

    public PosInvoice getMaskedInvoice(PosInvoice invoice){
        invoice.setCustomerCardNo(null);
        if (invoice.getDeliveryType().equalsIgnoreCase("HOME-DELIVERY")) {
            invoice.getDeliveryAddress().setAddressLine(null);
            invoice.getDeliveryAddress().setContactNumber(null);
        }
        return invoice;
    }

}
