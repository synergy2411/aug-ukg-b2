package com.sk.employee_service.service;

import com.sk.employee_service.dto.EmployeeDto;

public interface IEmployeeService {
    void createEmployee(EmployeeDto employeeDto);

    EmployeeDto fetchEmployee(String mobileNumber);

    boolean updateEmployee(EmployeeDto employeeDto);

    boolean deleteEmployee(String mobileNumber);
}
