package com.dgmf.controller;

import com.dgmf.dto.EmployeeDto;
import com.dgmf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    // Create Employee REST API
    @PostMapping
    private ResponseEntity<EmployeeDto> createEmployee(
            @RequestBody EmployeeDto employeeDto
    ) {
        return new ResponseEntity<>(
                employeeService.createEmployee(employeeDto),
                HttpStatus.CREATED
        );
    }
}
