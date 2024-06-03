package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/department")
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public Department add(@RequestBody Department department){
        departmentService.add(department);
        return department;
    }
    @PutMapping("/updata/{id}")
    public Department updata(@PathVariable Integer id,@RequestBody Department department){
        departmentService.updata(id,department);
        return departmentService.updata(id,department);
    }

    @GetMapping("/get/{id}")
    public Department findById(@PathVariable Integer id){
        return departmentService.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        departmentService.delete(id);
    }
}
