package com.tg.tarabutget.service.impl;

import com.tg.tarabutget.dto.CustomerDto;
import com.tg.tarabutget.entity.Customer;
import com.tg.tarabutget.enums.MarketingPreference;
import com.tg.tarabutget.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {
    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCustomer() {
        when(customerRepository.findCustomerByUserName(anyString()))
                .thenReturn(Customer.builder()
                        .id(1L)
                        .customerName("TestUser")
                        .userName("User1")
                        .marketingPreference(MarketingPreference.EMAIL)
                        .build());

        CustomerDto customerDto = customerServiceImpl.getCustomer("testUser");
        assertEquals(MarketingPreference.EMAIL,customerDto.getMarketingPreference());
    }

    @Test
    void getCustomerWhenCustomerDoesNotExist() {
        when(customerRepository.findCustomerByUserName(anyString()))
                .thenReturn(null);

        CustomerDto customerDto = customerServiceImpl.getCustomer("testUser");
        assert customerDto == null;
    }
}