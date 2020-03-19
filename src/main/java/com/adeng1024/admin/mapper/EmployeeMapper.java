package com.adeng1024.admin.mapper;

import com.adeng1024.admin.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    Integer addEmp(Employee employee);

    Integer deleteEmpById(Integer id);

    Integer updateEmp(Employee employee);

    List<Employee> queryEmpList();

    Employee queryEmpById(Integer id);
}
