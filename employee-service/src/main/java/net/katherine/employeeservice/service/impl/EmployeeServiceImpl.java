package net.katherine.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.katherine.employeeservice.dto.APIResponseDto;
import net.katherine.employeeservice.dto.DepartmentDto;
import net.katherine.employeeservice.dto.EmployeeDto;
import net.katherine.employeeservice.entity.Employee;
import net.katherine.employeeservice.repository.EmployeeRepository;
import net.katherine.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    private WebClient webClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = modelMapper.map(employeeDto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);


        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        // Inject and Use WebClient to call the REST API
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}

