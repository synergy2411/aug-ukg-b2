package com.sk.employee_service.repository;

import com.sk.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByMobileNumber(String mobileNumber);

    @Transactional
    @Modifying
    void deleteByMobileNumber(String mobileNumber);
}
