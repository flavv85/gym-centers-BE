package com.flavius.gymcenter.manager;

import com.flavius.gymcenter.dto.PaymentDto;

import java.util.List;

public interface PaymentManagerService {
    PaymentDto addPayment(PaymentDto paymentDto, Long idCustomer);
    PaymentDto editPayment(PaymentDto paymentDto, Long id);
    PaymentDto findPaymentById(Long id);
    List<PaymentDto> findPaymentForCustomer(Long idCustomer);
    void deletePayment(Long id);
}
