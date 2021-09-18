package com.tg.tarabutget.repository;

import com.tg.tarabutget.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findCustomerByUserName(final String userName);
}