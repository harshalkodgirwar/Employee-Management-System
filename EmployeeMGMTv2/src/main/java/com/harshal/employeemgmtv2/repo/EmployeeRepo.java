package com.harshal.employeemgmtv2.repo;

import com.harshal.employeemgmtv2.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

}

