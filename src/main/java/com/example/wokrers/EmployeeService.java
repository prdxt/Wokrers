package com.example.wokrers;

import com.example.wokrers.Employee;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private Map<Integer, Employee> employees = new HashMap<>();

    public Employee addEmployee(Employee employee) {
        employees.put(employee.getEmployeeID(), employee);
        return employee;
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public Employee updateEmployee(int id, String position, int salary) {
        Employee employee = employees.get(id);
        if (employee != null) {
            employee.setPosition(position);
            employee.setSalary(salary);
        }
        return employee;
    }

    public Employee deleteEmployee(int id) {
        return employees.remove(id);
    }

    public Map<Integer, Employee> getAllEmployees() {
        return employees;
    }
}
