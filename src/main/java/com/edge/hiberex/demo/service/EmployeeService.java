package com.edge.hiberex.demo.service;

import com.edge.hiberex.demo.common.Pagination;
import com.edge.hiberex.demo.dto.EmployeeSearchCriteria;
import com.edge.hiberex.demo.entity.Employee;
import com.edge.hiberex.demo.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getById(int id) {
        return employeeRepository.findById(id);
    }

    public Page<Employee> search(EmployeeSearchCriteria criteria, Pagination pagination) {
        Specification<Employee> spec = createSpecification(criteria);
        Pageable pageable = createPageable(pagination);
        return employeeRepository.findAll(spec, pageable);
    }

    public List<Employee> search(EmployeeSearchCriteria criteria) {
        Specification<Employee> spec = createSpecification(criteria);
        return employeeRepository.findAll(spec);
    }

    private Pageable createPageable(Pagination pagination) {
        Sort.Direction direction = Sort.Direction.fromString(pagination.getSortDir());
        Sort sort = Sort.by(direction, pagination.getSortBy());
        return PageRequest.of(pagination.getPage(), pagination.getSize(), sort);
    }

    private Specification<Employee> createSpecification(EmployeeSearchCriteria criteria) {
        Specification<Employee> spec = Specification.where(null);

        if (criteria.getFirstName() != null && !criteria.getFirstName().isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")),
                "%" + criteria.getFirstName().toLowerCase() + "%"));
        }

        if (criteria.getLastName() != null && !criteria.getLastName().isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")),
                "%" + criteria.getLastName().toLowerCase() + "%"));
        }

        if (criteria.getLineOne() != null && !criteria.getLineOne().isEmpty()) {
            spec = spec.and(
                (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.join("addresses").get("lineOne")),
                    "%" + criteria.getLineOne().toLowerCase() + "%"));
        }

        return spec;
    }

}
