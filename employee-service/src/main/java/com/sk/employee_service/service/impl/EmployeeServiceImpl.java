package com.sk.employee_service.service.impl;

import com.sk.employee_service.dto.EmployeeDto;
import com.sk.employee_service.entity.Employee;
import com.sk.employee_service.mapper.EmployeeMapper;
import com.sk.employee_service.repository.EmployeeRepository;
import com.sk.employee_service.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto, new Employee());
        repository.save(employee);
    }
}
