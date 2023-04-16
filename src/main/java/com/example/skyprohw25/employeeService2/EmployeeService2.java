package com.example.skyprohw25.employeeService2;


import com.example.skyprohw25.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;

@Service
public class EmployeeService2 {
    private static final int SIZE = 5;
    private Employee[] staff = new Employee[SIZE];

    EmployeeService2() {
        staff[0] = new Employee("Василий", "Васильев", 50000, 1);
        staff[1] = new Employee("Виктор", "Генкин", 51000, 2);
        staff[2] = new Employee("Валерий", "Буров", 52000, 1);
        staff[3] = new Employee("Геннадий", "Букин", 53000, 2);
        staff[4] = new Employee("Георгий", "Гренкин", 54000, 2);
    }

    public Employee getMaxPaidByDept (int department) {
        return Arrays.stream(staff)
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Department number not found"));
    }

    public Employee getMinPaidByDept (int department) {
        return Arrays.stream(staff)
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Department number not found"));
    };


}
