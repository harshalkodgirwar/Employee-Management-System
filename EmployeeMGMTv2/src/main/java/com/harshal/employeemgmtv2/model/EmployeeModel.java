package com.harshal.employeemgmtv2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private long id;
    private String firstname;
    private String lastname;
    private String emailId;


}
