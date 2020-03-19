package com.adeng1024.admin.service.serviceImpl;

import com.adeng1024.admin.mapper.EmployeeMapper;
import com.adeng1024.admin.pojo.Employee;
import com.adeng1024.admin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Integer addEmp(Employee employee) {
        return employeeMapper.addEmp(employee);
    }

    @Override
    public Integer deleteEmpById(Integer id) {
        return employeeMapper.deleteEmpById(id);
    }

    @Override
    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateEmp(employee);
    }

    @Override
    public List<Employee> queryEmpList() {
        return employeeMapper.queryEmpList();
    }

    @Override
    public Employee queryEmpById(Integer id) {
        return employeeMapper.queryEmpById(id);
    }
}
