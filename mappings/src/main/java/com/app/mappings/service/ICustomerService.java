package com.app.mappings.service;

import com.app.mappings.Utilities.CustomApiResponse;
import com.app.mappings.entities.Customer;

public interface ICustomerService {

    CustomApiResponse saveNewCustomerDetails(Customer customer);
}
