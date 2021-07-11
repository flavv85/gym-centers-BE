package com.flavius.gymcenter.manager;

import com.flavius.gymcenter.dto.PaymentDto;

import java.util.List;

public interface PaymentManagerService {
    PaymentDto addPayment(PaymentDto paymentDto, long idCustomer);
    PaymentDto editPayment(PaymentDto paymentDto, long id);
    PaymentDto findPaymentById(long id);
    List<PaymentDto> findPaymentForCustomer(long idCustomer);
    void deletePayment(long id);
}
