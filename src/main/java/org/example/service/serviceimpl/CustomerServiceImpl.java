package org.example.service.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.example.dto.CustomerDto;
import org.example.entity.CustomerEntity;
import org.example.repostory.CustomerRepostory;
import org.example.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepostory repostory;
    private final ModelMapper modelMapper;
    @Override
    public void addCustomer(CustomerDto customerDto) {
        repostory.save(modelMapper.map(customerDto, CustomerEntity.class));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        ArrayList<CustomerDto> objectslist = new ArrayList<>();
        List<CustomerEntity> all = repostory.findAll();

        all.forEach(CustomerEntity->{
            objectslist.add(modelMapper.map(CustomerEntity,CustomerDto.class));
        });
        return objectslist;
    }

    @Override
    public CustomerDto getCustomerById(Long customerid) {
        return modelMapper.map(repostory.findById(customerid), CustomerDto.class);
    }

    @Override
    public void updateCustomer(Long customerid, CustomerDto customerDto) {
        repostory.save(modelMapper.map(customerDto, CustomerEntity.class));

    }

    @Override
    public void deleteCustomer(Long customerid) {
        repostory.deleteById(customerid);

    }
}
