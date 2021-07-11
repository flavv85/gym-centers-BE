package com.flavius.gymcenter.impl;

import com.flavius.gymcenter.dao.PaymentDao;
import com.flavius.gymcenter.model.Customer;
import com.flavius.gymcenter.model.Payment;
import com.flavius.gymcenter.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Payment addPayment(Payment payment, Customer customer) {
        customer.addPayment(payment);
        return paymentDao.save(payment);
    }

    @Override
    public Payment editPayment(Payment payment, Payment existsPayment) {
        existsPayment.setCost(payment.getCost());
        existsPayment.setDate(payment.getDate());
        existsPayment.setDuration(payment.getDuration());
        return paymentDao.save(existsPayment);
    }
}
