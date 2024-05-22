package com.dgmf.controller;

import com.dgmf.dto.EmployeeDto;
import com.dgmf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
// Making All the Clients Able to Call these Below
// Employee Related REST APIs
@CrossOrigin("*")
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

    // Get Employee By Id REST API
    @GetMapping("/{id}")
    private ResponseEntity<EmployeeDto> getEmployeeById(
            @PathVariable("id") Long EmployeeDtoId
    ) {
        return ResponseEntity.ok(employeeService.getEmployeeById(EmployeeDtoId));
    }

    // Get All Employees REST API
    @GetMapping
    private ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Update Employee By Id REST API
    @PutMapping("/{id}")
    private ResponseEntity<EmployeeDto> updateEmployeeById(
            @PathVariable("id") Long EmployeeDtoId,
            @RequestBody EmployeeDto employeeDto
    ) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(
                EmployeeDtoId, employeeDto
                )
            );
    }

    // Delete Employee By Id REST API
    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteEmployeeById(
            @PathVariable("id") Long EmployeeDtoId
    ) {
        employeeService.deleteEmployeeById(EmployeeDtoId);

        return ResponseEntity.ok("Employee Deleted Successfully !");
    }
}
