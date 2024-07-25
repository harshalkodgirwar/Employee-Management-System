package com.harshal.employeemgmtv2.service;

import com.harshal.employeemgmtv2.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    EmployeeModel createEmployee(EmployeeModel employee);

    List<EmployeeModel> getAllEmployees();

    boolean deleteEmployee(long id);

    EmployeeModel getEmployeeById(long id);

    EmployeeModel updateEmployee(long id, EmployeeModel employee);
}
