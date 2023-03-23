package net.katherine.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.katherine.departmentservice.dto.DepartmentDto;
import net.katherine.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
       DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
       return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByDepartmentCode(@PathVariable("department-code") String departmentCode) {
        DepartmentDto departmentDto = departmentService.getDepartmentDtoByCode(departmentCode);
        return ResponseEntity.ok(departmentDto);
    }
}
