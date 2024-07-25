package com.harshal.employeemgmtv2.service;

import com.harshal.employeemgmtv2.entity.EmployeeEntity;
import com.harshal.employeemgmtv2.model.EmployeeModel;
import com.harshal.employeemgmtv2.repo.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepo repo;

    public EmployeeServiceImpl(EmployeeRepo repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeModel createEmployee(EmployeeModel employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        repo.save(employeeEntity);
        return employee;
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = repo.findAll();
        List<EmployeeModel> employeeModels = employeeEntities.stream().map(emp -> new EmployeeModel(emp.getId(),emp.getFirstname(),emp.getLastname(),emp.getEmailId())).collect(Collectors.toList());
        return employeeModels;
    }

    @Override
    public boolean deleteEmployee(long id) {
        EmployeeEntity employee = repo.findById(id).get();
        repo.delete(employee);
        return true;
    }

    @Override
    public EmployeeModel getEmployeeById(long id) {
        EmployeeEntity employeeEntity = repo.findById(id).get();
        EmployeeModel employee = new EmployeeModel();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public EmployeeModel updateEmployee(long id, EmployeeModel employee) {
        EmployeeEntity employeeEntity = repo.findById(id).get();
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstname(employee.getFirstname());
        employeeEntity.setLastname(employee.getLastname());

        repo.save(employeeEntity);
        return employee;
    }
}
