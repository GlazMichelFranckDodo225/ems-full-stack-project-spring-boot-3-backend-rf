package com.dgmf.service.impl;

import com.dgmf.dto.EmployeeDto;
import com.dgmf.entity.Employee;
import com.dgmf.mapper.EmployeeMapper;
import com.dgmf.repository.EmployeeRepository;
import com.dgmf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
