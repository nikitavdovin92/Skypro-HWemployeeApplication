package com.example.skyprohw25.service;

import com.example.skyprohw25.exception.EmployeeAlreadyAddedException;
import com.example.skyprohw25.exception.EmployeeNotFoundException;
import com.example.skyprohw25.exception.EmployeeStorageIsFullException;
import com.example.skyprohw25.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private static final int SIZE = 3;
    private final List<Employee> employees = new ArrayList<>(SIZE);
    @PostConstruct
    public void initial() {
        employees.add(new Employee("Ivan", "Ivanov"));
        employees.add(new Employee("Ivan", "Petrov"));
        employees.add(new Employee("Ivan", "Smirnov"));
    }

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < SIZE) {
            for (Employee emp : employees) {
                if (emp.equals(employee)) {
                    throw new EmployeeAlreadyAddedException();
                }
            }
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }


    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
            }
        throw new EmployeeNotFoundException();
    }
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.remove(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> list() {
        return Collections.unmodifiableList(employees);
    }
}
