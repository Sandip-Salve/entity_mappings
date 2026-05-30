package com.app.mappings.controller;

import com.app.mappings.Utilities.CustomApiResponse;
import com.app.mappings.entities.Customer;
import com.app.mappings.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomApiResponse> createNewCustomer(@RequestBody Customer customer){
        CustomApiResponse customApiResponse  = customerService.saveNewCustomerDetails(customer);
        return new ResponseEntity<>(customApiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerDetailsById(@PathVariable("customerId") Long customerId){
        Customer customer = customerService.getCustomerDetailsByCustomerId(customerId);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
}
