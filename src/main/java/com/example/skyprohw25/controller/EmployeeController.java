package com.example.skyprohw25.controller;
import com.example.skyprohw25.exception.EmployeeNotFoundException;
import com.example.skyprohw25.model.Employee;
import com.example.skyprohw25.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/add")
    public Employee add (@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName);

    }

    @GetMapping(value = "/remove")
    public Employee remove (@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);

    }

    @GetMapping(value = "/find")
    public Employee find (@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);

    }
    @GetMapping(value = "/")
    public List<Employee> list() {
        return employeeService.list();
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> employeeNotFoundExceptionHandler(EmployeeNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Сотрудник не найден");
    }
}
