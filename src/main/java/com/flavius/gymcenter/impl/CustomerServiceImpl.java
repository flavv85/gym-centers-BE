package com.flavius.gymcenter.impl;

import com.flavius.gymcenter.dao.CustomerDao;
import com.flavius.gymcenter.model.Customer;
import com.flavius.gymcenter.service.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer editCustomer(Customer customer, Customer existsCustomer) {
        existsCustomer.setFirstName(customer.getFirstName());
        existsCustomer.setLastName(customer.getLastName());
        existsCustomer.setAge(customer.getAge());
        existsCustomer.setSex(customer.getSex());
        existsCustomer.setAvatar(customer.getAvatar());
        return customerDao.save(existsCustomer);
    }
}
