package com.flavius.gymcenter.managerImpl;

import com.flavius.gymcenter.dao.CustomerDao;
import com.flavius.gymcenter.dto.CustomerDto;
import com.flavius.gymcenter.manager.CustomerManagerService;
import com.flavius.gymcenter.model.Customer;
import com.flavius.gymcenter.model.OrikaBeanMapper;
import com.flavius.gymcenter.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CustomerManagerServiceImpl implements CustomerManagerService {

    private final OrikaBeanMapper orikaBeanMapper;
    private final CustomerDao customerDao;
    private final CustomerService customerService;

    public CustomerManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, CustomerDao customerDao, CustomerService customerService) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.customerDao = customerDao;
        this.customerService = customerService;
    }

    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = orikaBeanMapper.map(customerDto, Customer.class);
        return orikaBeanMapper.convertDTO(customerService.addCustomer(customer), CustomerDto.class);
    }

    @Override
    public CustomerDto editCustomer(CustomerDto customerDto, long id) {
        Customer customer = orikaBeanMapper.map(customerDto, Customer.class);
        Customer existsCustomer = customerDao.findById(id).orElse(null);
        return orikaBeanMapper.convertDTO(customerService.editCustomer(customer, existsCustomer), CustomerDto.class );
    }

    @Override
    public CustomerDto findCustomerById(long id) {
        return orikaBeanMapper.convertDTO(customerDao.findById(id).orElse(null), CustomerDto.class);
    }

    @Override
    public void deleteCustomer(long id) {
    Customer existsCustomer = customerDao.findById(id).orElse(null);
    customerDao.delete(existsCustomer);
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerDao.findAll();
        return orikaBeanMapper.convertListDTO(customers, CustomerDto.class);
    }
}
