package com.example.demo.service.impl;

import com.example.demo.dao.DepartmentDaoMapper;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDaoMapper departmentDaoMapper;

    @Override
    public Department add(Department department) {
        departmentDaoMapper.add(department);
        return department;
    }
}
