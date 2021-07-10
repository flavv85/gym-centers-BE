package com.flavius.gymcenter.service;

import com.flavius.gymcenter.model.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    Customer editCustomer(Customer customer, Customer existsCustomer);
}
