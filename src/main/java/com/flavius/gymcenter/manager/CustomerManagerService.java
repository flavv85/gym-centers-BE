package com.flavius.gymcenter.manager;

import com.flavius.gymcenter.dto.CustomerDto;

import java.util.List;

public interface CustomerManagerService {
    CustomerDto addCustomer(CustomerDto customerDto);
    CustomerDto editCustomer(CustomerDto customerDto, long id);
    CustomerDto findCustomerById(long id);
    void deleteCustomer(long id);
    List<CustomerDto> findAllCustomers();
}
