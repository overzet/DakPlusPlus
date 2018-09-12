package applications;

import daos.EmployeeDao;
import entities.Employee;
import services.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestApp {

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(("D++"));
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EmployeeDao employeeDao = new EmployeeDao(entityManager);

        EmployeeService employeeService = new EmployeeService(employeeDao);


        Employee employee = employeeDao.find(24);


        System.out.println(employee);
    }

}
