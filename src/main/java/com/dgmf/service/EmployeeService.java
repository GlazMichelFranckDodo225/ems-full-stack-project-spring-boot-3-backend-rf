package com.dgmf.service;

import com.dgmf.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeDtoId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployeeById(Long employeeDtoId, EmployeeDto employeeDto);
}
