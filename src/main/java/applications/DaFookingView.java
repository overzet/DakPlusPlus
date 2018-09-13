package applications;

import daos.EmployeeDao;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DaFookingView {

    private EmployeeDao employeeDao;
    private BufferedReader userInputReader;

    public static void main(String[] args) throws IOException {


        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory(("D++"));
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();

        EmployeeDao employeeDao = new EmployeeDao(entityManager);

        BufferedReader userInputReader =
                new BufferedReader(new InputStreamReader(System.in));
        new DaFookingView(employeeDao, userInputReader).run();
    }

    public DaFookingView(EmployeeDao userDao, BufferedReader userInputReader) {
        this.employeeDao = userDao;
        this.userInputReader = userInputReader;
    }

    private void run() throws IOException {
        System.out.println("Enter an option: "
                + "1) Insert a new user. "
                + "2) Find a user. "
                + "3) Edit a user. "
                + "4) Delete a user.");
        int option = Integer.parseInt(userInputReader.readLine());

        switch (option) {
            case 1:
                persistNewUser();
                break;
            case 2:
                fetchExistingUser();
                break;
            case 3:
                updateExistingUser();
                break;
            case 4:
                removeExistingUser();
                break;
        }
    }

    private void persistNewUser() throws IOException {
        String name = requestStringInput("the name of the user");
        Integer age = requestIntegerInput("the age of the user");
        employeeDao.persist(name, age);
    }

    private void fetchExistingUser() throws IOException {
        int id = requestIntegerInput("the user ID");
        Employee employee= employeeDao.find(id);
        System.out.print("Name : " + employee.getName() + " Age : " + employee.getAge());
    }

    private void updateExistingUser() throws IOException {
        int id = requestIntegerInput("the user ID");
        String name = requestStringInput("the name of the user");
        Integer age = requestIntegerInput("the age of the user");
        employeeDao.update(id, name, age);
    }

    private void removeExistingUser() throws IOException {
        int id = requestIntegerInput("the user ID");
        employeeDao.remove(id);
    }

    private String requestStringInput(String request) throws IOException {
        System.out.printf("Enter %s: ", request);
        return userInputReader.readLine();
    }

    private int requestIntegerInput(String request) throws IOException {
        System.out.printf("Enter %s: ", request);
        return Integer.parseInt(userInputReader.readLine());
    }

}