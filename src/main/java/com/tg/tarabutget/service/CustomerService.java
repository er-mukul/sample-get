package com.tg.tarabutget.service;

import com.tg.tarabutget.dto.CustomerDto;

public interface CustomerService {
    CustomerDto getCustomer(String userName);
}
