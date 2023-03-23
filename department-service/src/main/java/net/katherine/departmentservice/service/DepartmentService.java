package net.katherine.departmentservice.service;

import net.katherine.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentDtoByCode(String code);
}
