package com.flavius.gymcenter.manager;

import com.flavius.gymcenter.dto.CustomerDto;

import java.util.List;

public interface CustomerManagerService {
    CustomerDto addCustomer(CustomerDto customerDto);
    CustomerDto editCustomer(CustomerDto customerDto, Long id);
    CustomerDto findCustomerById(Long id);
    void deleteCustomer(Long id);
    List<CustomerDto> findAllCustomers();
}
