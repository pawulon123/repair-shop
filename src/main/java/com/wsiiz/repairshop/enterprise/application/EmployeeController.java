package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.employee.Employee;
import com.wsiiz.repairshop.enterprise.domain.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public ResponseEntity<Employee> addNew(
            @RequestBody Employee employee
        ) {
      employee.getSkills().forEach(s -> s.setEmployee(employee));
        return ResponseEntity.created(null).body(employeeRepository.save(employee));
    }
    @GetMapping("/employee/{id}")
    public Optional<Employee> getOne(
            @PathVariable("id") Long id
        ) {
        return employeeRepository.findById(id);
    }
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getMany(
            @RequestParam(value = "branch", required = false) Long branchId
            ) {
        return branchId == null ? ResponseEntity.ok(employeeRepository.findAll()) : ResponseEntity.ok(employeeRepository.findByBranchId(branchId));
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<ResponseEntity> remove(
            @PathVariable("id") Long id
        ) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
