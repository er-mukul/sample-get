package com.tg.tarabutget.service.impl;

import com.tg.tarabutget.dto.CustomerDto;
import com.tg.tarabutget.entity.Customer;
import com.tg.tarabutget.repository.CustomerRepository;
import com.tg.tarabutget.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto getCustomer(String userName) {
        Customer customer = customerRepository.findCustomerByUserName(userName);
        if(customer!=null){
            return CustomerDto.builder()
                    .id(customer.getId())
                    .customerName(customer.getCustomerName())
                    .userName(customer.getUserName())
                    .marketingPreference(customer.getMarketingPreference())
                    .build();
        } else{
            return null;
        }
    }
}
