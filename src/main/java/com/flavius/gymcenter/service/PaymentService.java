package com.flavius.gymcenter.service;

import com.flavius.gymcenter.model.Customer;
import com.flavius.gymcenter.model.Payment;

public interface PaymentService {
    Payment addPayment(Payment payment, Customer customer);

    Payment editPayment(Payment payment, Payment existsPayment);
}
