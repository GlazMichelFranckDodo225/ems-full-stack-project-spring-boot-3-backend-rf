package com.dgmf.service.impl;

import com.dgmf.dto.EmployeeDto;
import com.dgmf.entity.Employee;
import com.dgmf.mapper.EmployeeMapper;
import com.dgmf.repository.EmployeeRepository;
import com.dgmf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeDtoId) {
        Employee employee = employeeRepository.findById(employeeDtoId)
                .orElseThrow(() -> new RuntimeException(
                        "Employee Not Found with Given Id : " + employeeDtoId
                    )
                );

        return employeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(
                employeeMapper::mapToEmployeeDto
        ).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployeeById(
            Long employeeDtoId, EmployeeDto employeeDto
    ) {
        Employee employee = employeeRepository.findById(employeeDtoId)
                .orElseThrow(() -> new RuntimeException(
                                "Employee Not Found with Given Id : " + employeeDtoId
                        )
                );

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        employeeRepository.save(employee);

        return employeeMapper.mapToEmployeeDto(employee);
    }
}
