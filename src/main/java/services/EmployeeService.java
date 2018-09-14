/**
 * @author JOverzet
 * @version 3.25
 *
 * This service class handles requests from a user,
 * encapsulating business logic and persistence away from the action being taken.
 */

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
