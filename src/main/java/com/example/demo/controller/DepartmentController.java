package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/department")
@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("/add")
    public Department add(Department department){
        departmentService.add(department);
        return department;
    }
}
