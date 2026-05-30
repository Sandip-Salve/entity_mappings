package com.app.mappings.repository;

import com.app.mappings.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRespository extends JpaRepository<Customer,Long> {
}
