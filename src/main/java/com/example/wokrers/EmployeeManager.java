package com.example.wokrers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add_employee";
    }

    private int i = 0;
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employee.setId(i++);
        employees.add(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Employee employee = findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit_employee";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id, @ModelAttribute Employee updatedEmployee) {
        Employee employee = findEmployeeById(id);
        employee.setPosition(updatedEmployee.getPosition());
        employee.setSalary(updatedEmployee.getSalary());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        Employee employee = findEmployeeById(id);
        employees.remove(employee);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchEmployees(@RequestParam("lastName") String lastName, Model model) {
        List<Employee> matchingEmployees = findEmployeesByLastName(lastName);
        model.addAttribute("employees", matchingEmployees);
        return "index";
    }

    private Employee findEmployeeById(Long id) {
        return employees.stream()
                .filter(employee -> employee.getId()==id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono pracownika o podanym ID"));
    }

    private List<Employee> findEmployeesByLastName(String lastName) {
        return employees.stream()
                .filter(employee -> employee.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }
}
