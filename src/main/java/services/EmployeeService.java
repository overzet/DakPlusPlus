package services;

import daos.EmployeeDao;
import entities.Employee;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAllEmployee();
    }
}
