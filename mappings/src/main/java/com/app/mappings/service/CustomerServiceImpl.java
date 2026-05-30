package com.app.mappings.service;


import com.app.mappings.Utilities.CustomApiResponse;
import com.app.mappings.entities.Customer;
import com.app.mappings.entities.Order;
import com.app.mappings.repository.ICustomerRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService{


    private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private ICustomerRespository customerRespository;

    @Transactional
    @Override
    public CustomApiResponse saveNewCustomerDetails(Customer customer) {
        logger.debug("Inside saveNewCustomerDetails method: {}",customer);
        List<Order> orders = customer.getOrders();
        for(Order order : orders){
            order.setCustomer(customer);
        }
        Customer newCustomer = customerRespository.save(customer);
        return new CustomApiResponse("New Customer created with Customer ID: "+newCustomer.getCustomerId());
    }

    @Override
    public Customer getCustomerDetailsByCustomerId(Long customerId) {
        logger.debug("Inside getCustomerDetailsByCustomerId method: {}",customerId);
        Optional<Customer> optionalCustomer = customerRespository.findById(customerId);
        return optionalCustomer.orElse(null);
    }
}
