package com.tg.tarabutget.controller;

import com.tg.tarabutget.dto.CustomerDto;
import com.tg.tarabutget.enums.MarketingPreference;
import com.tg.tarabutget.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CustomerControllerTest {
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCustomer() {
        when(customerService.getCustomer(anyString()))
                .thenReturn(CustomerDto.builder()
                        .id(1L)
                        .customerName("TestUser")
                        .userName("User1")
                        .marketingPreference(MarketingPreference.EMAIL)
                        .build());

        ResponseEntity<CustomerDto> response = customerController.getCustomer("TestUser");
        CustomerDto customerDto = response.getBody();
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assert customerDto != null;
        assertEquals(MarketingPreference.EMAIL,customerDto.getMarketingPreference());
    }

    @Test
    void getCustomerWhenCustomerDoesNotExist() {
        when(customerService.getCustomer(anyString()))
                .thenReturn(null);

        ResponseEntity<CustomerDto> response = customerController.getCustomer("TestUser");
        CustomerDto customerDto = (CustomerDto)response.getBody();
        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
        assert customerDto == null;
    }
}