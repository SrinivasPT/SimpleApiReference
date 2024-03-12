package com.edge.hiberex.demo.controller;

import com.edge.hiberex.demo.common.SearchRequest;
import com.edge.hiberex.demo.dto.EmployeeSearchCriteria;
import com.edge.hiberex.demo.entity.Employee;
import com.edge.hiberex.demo.service.EmployeeService;
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
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Optional<Employee> employee = employeeService.getById(id);
        return employee.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/search")
    public ResponseEntity<List<Employee>> search(@RequestBody EmployeeSearchCriteria criteria) {
        List<Employee> employees = employeeService.search(criteria);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/search-with-pagination")
    public ResponseEntity<Page<Employee>> searchWithPagination(@RequestBody SearchRequest<EmployeeSearchCriteria> searchRequest) {
        Page<Employee> employees = employeeService.search(searchRequest.getSearchCriteria(), searchRequest.getPagination());
        return ResponseEntity.ok(employees);
    }

}
