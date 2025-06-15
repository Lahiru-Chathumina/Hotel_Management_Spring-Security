package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CustomerDto;
import org.example.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin

@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping("/add")
   public void addCustomer(@RequestBody CustomerDto customerDto){
       service.addCustomer(customerDto);
   }

    @GetMapping("/all")
    public List<CustomerDto> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @PutMapping("/update/{id}")
    public void updateCustomer(@PathVariable("id") Long customerid, @RequestBody CustomerDto customerDto) {
        service.updateCustomer(customerid, customerDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable("id") Long customerid) {
        service.deleteCustomer(customerid);
    }
}
