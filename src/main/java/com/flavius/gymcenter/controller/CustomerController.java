package com.flavius.gymcenter.controller;

import com.flavius.gymcenter.dto.CustomerDto;
import com.flavius.gymcenter.manager.CustomerManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    private final CustomerManagerService customerManagerService;

    public CustomerController(CustomerManagerService customerManagerService) {
        this.customerManagerService = customerManagerService;
    }

    @GetMapping("/findAllCustomers")
    List<CustomerDto> findAllCustomers() {
        return customerManagerService.findAllCustomers();
    }

    @GetMapping("/findCustomerById/{id}")
    CustomerDto findCustomerById(@PathVariable Long id) {
        return customerManagerService.findCustomerById(id);
    }

    @PostMapping("/addCustomer")
    CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
        return customerManagerService.addCustomer(customerDto);
    }

    @PutMapping("/editCustomer/{id}")
    CustomerDto editCustomer(@RequestBody CustomerDto customerDto, @PathVariable Long id){
        return customerManagerService.editCustomer(customerDto, id);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    void deleteCustomer(@PathVariable Long id){
        customerManagerService.deleteCustomer(id);
    }
}
