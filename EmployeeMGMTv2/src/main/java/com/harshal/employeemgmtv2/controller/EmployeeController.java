package com.harshal.employeemgmtv2.controller;

import com.harshal.employeemgmtv2.model.EmployeeModel;
import com.harshal.employeemgmtv2.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id){
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable long id){
        EmployeeModel employee = null;
        employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable long id, @RequestBody EmployeeModel employee){
        employee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(employee);
    }
}
