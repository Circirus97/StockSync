package com.riwi.StockSync.domain.repositories;

import com.riwi.StockSync.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

    Optional<Employee> findByIdentity(String documentNumber);

}
