package org.example.service;

import org.example.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long customerid);

    void updateCustomer(Long customerid, CustomerDto customerDto);

    void deleteCustomer(Long customerid);
}
