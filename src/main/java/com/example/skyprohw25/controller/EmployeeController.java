package com.example.skyprohw25.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.skyprohw25.service.EmployeeService;
import com.example.skyprohw25.model.Employee;

import java.util.Collection;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;
    EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping(value = "/add")
    public Employee addEmployee (@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam int department) {
        return service.add (firstName,lastName, salary, department);

    }

    @GetMapping(value = "/remove")
    public Employee removeEmployee (@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam int department) {
        return service.remove(firstName,lastName, salary, department);

    }

    @GetMapping(value = "/find")
    public Employee find (@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam int department) {
        return service.find(firstName,lastName, salary, department);
    }

    @GetMapping
    public Collection<Employee> findAll () {
        return service.findAll();
    }

}
