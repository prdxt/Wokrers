package com.example.wokrers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee addEmployee(@ModelAttribute Employee employee, Model model) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee.getPosition(), employee.getSalary());
    }

    @DeleteMapping("/employee/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees")
    public Map<Integer, Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }
}
