package com.dgmf.mapper;

import com.dgmf.dto.EmployeeDto;
import com.dgmf.entity.Employee;
import org.modelmapper.ModelMapper;

/*@Component
@RequiredArgsConstructor*/
public class EmployeeMapper {
    private ModelMapper modelMapper;

    public EmployeeDto mapToEmployeeDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public Employee mapToEmployee(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }
}
