package com.edge.hiberex.demo.controller;

import com.edge.hiberex.demo.common.ApiResponse;
import com.edge.hiberex.demo.common.SearchRequest;
import com.edge.hiberex.demo.dto.EmployeeSearchCriteria;
import com.edge.hiberex.demo.entity.Employee;
import com.edge.hiberex.demo.service.EmployeeService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ApiResponse<Employee> getEmployeeById(@PathVariable int id) {
        Optional<Employee> employee = employeeService.getById(id);
        return employee.map(e -> ApiResponse.success(e))
            .orElseGet(() -> ApiResponse.error(null, "Employee not found"));
    }

    @PostMapping("/search")
    public ApiResponse<List<Employee>> search(@Valid @RequestBody EmployeeSearchCriteria criteria) {
        List<Employee> employees = employeeService.search(criteria);
        return ApiResponse.success(employees);
    }

    @PostMapping("/search-with-pagination")
    public ResponseEntity<ApiResponse<Page<Employee>>> searchWithPagination(
        @Valid @RequestBody SearchRequest<EmployeeSearchCriteria> searchRequest) {
        Page<Employee> employees = employeeService.search(searchRequest.getSearchCriteria(), searchRequest.getPagination());
        return ResponseEntity.ok(ApiResponse.success(employees));
    }

}
