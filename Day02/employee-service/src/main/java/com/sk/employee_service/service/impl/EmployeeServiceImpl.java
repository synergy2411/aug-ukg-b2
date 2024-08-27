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

    @Override
    public boolean updateEmployee(EmployeeDto employeeDto) {
        boolean isUpdated = false;
        if(employeeDto.getMobileNumber() == null){
            return isUpdated;
        }
        Employee employee = repository.findByMobileNumber(employeeDto.getMobileNumber()).orElseThrow(
                () -> new EmployeeNotFoundException("Employee does not exists for mobile number - " + employeeDto.getMobileNumber())
        );

        Employee updatedEmployee = EmployeeMapper.mapToEmployee(employeeDto, employee);
        repository.save(updatedEmployee);
        isUpdated = true;

        return isUpdated;
    }

    @Override
    public boolean deleteEmployee(String mobileNumber) {
        boolean isDeleted = false;
        if(mobileNumber == null){
            return isDeleted;
        }
        repository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new EmployeeNotFoundException("Employee does not exists for mobile number - " + mobileNumber)
        );
        repository.deleteByMobileNumber(mobileNumber);
        isDeleted = true;
        return isDeleted;
    }
}
