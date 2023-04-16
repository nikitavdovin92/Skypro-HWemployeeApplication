package com.example.skyprohw25.controller2.departments;


import com.example.skyprohw25.model.Employee;
import com.example.skyprohw25.employeeService2.EmployeeService2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final EmployeeService2 employeeService2;

    DepartmentsController (EmployeeService2 servis) {
        this.employeeService2 = servis;
    }



    @GetMapping("/max-salary?departmentId=5")
    public Employee getMaxPaidByDept (@RequestParam ("departmentId") Integer id) {
        return employeeService2.getMaxPaidByDept(id);
    }

    @GetMapping("/min-salary?departmentId=5")
    public Employee getMinPaidByDept (@RequestParam ("departmentId") Integer id) {
        return employeeService2.getMinPaidByDept(id);
    }

}
