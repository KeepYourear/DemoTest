package com.example.demo.dao;

import com.example.demo.entity.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentDaoMapper {
    void add(Department department);

    void updata(Department department);
    Department findById(Integer id);
    void delete(Integer id);



}
