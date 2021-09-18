package com.tg.tarabutget.controller;

import com.tg.tarabutget.dto.CustomerDto;
import com.tg.tarabutget.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer", produces = "application/json")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{userName}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable(name = "userName") String userName) {
        CustomerDto customerDto = customerService.getCustomer(userName);
        if(customerDto!=null){
            return ResponseEntity.ok(customerDto);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
}
