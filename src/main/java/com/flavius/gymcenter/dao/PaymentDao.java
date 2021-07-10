package com.flavius.gymcenter.dao;

import com.flavius.gymcenter.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository<Payment, Long> {
}
