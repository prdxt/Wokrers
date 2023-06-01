package com.example.wokrers;

public class Employee {

    private int id;
    private String name;
    private String lastName;
    private String position;
    private double salary;

    public Employee() {
    }
    public Employee(int id, String name, String lastName, String position, double salary){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
