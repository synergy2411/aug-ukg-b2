package com.sk.employee_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Employee name can not be empty")
    @NotNull(message = "Employee name can not be empty")
    private String name;

    @NotEmpty(message = "Email can not be empty")
    @NotNull(message = "Email can not be empty")
    private String email;

    @NotEmpty(message = "Mobile number can not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should have 10 digits")
    private String mobileNumber;


    private String designation;
    private String department;

}
