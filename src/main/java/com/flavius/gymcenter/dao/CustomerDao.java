package com.flavius.gymcenter.dao;

import com.flavius.gymcenter.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}
