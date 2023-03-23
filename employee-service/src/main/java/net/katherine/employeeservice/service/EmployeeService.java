package net.katherine.employeeservice.service;

import net.katherine.employeeservice.dto.APIResponseDto;
import net.katherine.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
