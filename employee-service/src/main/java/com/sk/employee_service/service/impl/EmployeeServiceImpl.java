package com.sk.employee_service.service.impl;

import com.sk.employee_service.dto.EmployeeDto;
import com.sk.employee_service.entity.Employee;
import com.sk.employee_service.exceptions.EmployeeAlreadyExistsException;
import com.sk.employee_service.exceptions.EmployeeNotFoundException;
import com.sk.employee_service.mapper.EmployeeMapper;
import com.sk.employee_service.repository.EmployeeRepository;
import com.sk.employee_service.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = repository.findByMobileNumber(employeeDto.getMobileNumber());

        if(employeeOptional.isPresent()){
            throw new EmployeeAlreadyExistsException("Employee already exists with mobile number - " + employeeDto.getMobileNumber());
        }

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto, new Employee());
        repository.save(employee);
    }

    @Override
    public EmployeeDto fetchEmployee(String mobileNumber) {
        Employee employee = repository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new EmployeeNotFoundException("Employee does not exists for mobile number - " + mobileNumber)
        );

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee, new EmployeeDto());
        return employeeDto;
    }
}
