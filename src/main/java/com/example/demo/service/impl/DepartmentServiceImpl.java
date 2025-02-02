package com.example.demo.service.impl;

import com.example.demo.dao.DepartmentDaoMapper;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDaoMapper departmentDaoMapper;

    @Override
    public Department add(Department department) {
        departmentDaoMapper.add(department);
        return department;
    }

    @Override
    public Department updata(Integer id, Department department) {
        department.setId(id);
        departmentDaoMapper.updata(department);
        return department;
    }

    @Override
    public Department findById(Integer id) {
        return departmentDaoMapper.findById(id);
    }

    @Override
    public void delete(Integer id) {
        departmentDaoMapper.delete(id);
        System.out.println("删除成功");
    }
}
