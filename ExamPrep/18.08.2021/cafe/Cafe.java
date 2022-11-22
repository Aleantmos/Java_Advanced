package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees = new ArrayList<>();

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {
        int freeSpace = employees.size();

        if (freeSpace < this.capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        boolean isRemoved = false;
        Employee employeeToRemove = null;

        for (Employee employee : employees) {
            if(employee.getName().equals(name)) {
                employeeToRemove = employee;
                employees.remove(employeeToRemove);
                isRemoved = true;
                break;
            }
        }
        return isRemoved;
    }

    public Employee getOldestEmployee() {
        int oldest = 0;
        Employee oldestEmployee = null;

        for (Employee employee : employees) {
            if (employee.getAge() > oldest) {
                oldest = employee.getAge();
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        Employee employeeToReturn = null;

        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employeeToReturn = employee;
                break;
            }
        }
        return employeeToReturn;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder cafeFormat = new StringBuilder();
        cafeFormat.append(String.format("Employees working at cafe %s", name)).append(System.lineSeparator());

        for (Employee employee : employees) {
            cafeFormat.append(employee.toString()).append(System.lineSeparator());
        }

        return cafeFormat.toString();
    }
}
