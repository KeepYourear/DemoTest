package com.example.demo.service;

import com.example.demo.entity.Department;

public interface DepartmentService {
    Department add(Department department);
    Department updata(Integer id,Department department);
    Department findById(Integer id);
    void delete(Integer id);
}
