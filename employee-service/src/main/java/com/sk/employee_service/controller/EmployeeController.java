package com.sk.employee_service.controller;

import com.sk.employee_service.dto.EmployeeDto;
import com.sk.employee_service.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping("/create")
    public String createEmployee(@RequestBody EmployeeDto employeeDto){
        iEmployeeService.createEmployee(employeeDto);
        return "Success";
    }

    @GetMapping("/greet")
    public String greet(){
        return "Hello World!";
    }

}
