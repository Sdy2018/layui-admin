package com.adeng1024.admin.service;

import com.adeng1024.admin.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    Integer addEmp(Employee employee);

    Integer deleteEmpById(Integer id);

    Integer updateEmp(Employee employee);

    List<Employee> queryEmpList();

    Employee queryEmpById(Integer id);
}
