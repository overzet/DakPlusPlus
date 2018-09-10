/**
 * Performing CRUD Operations on Entities – Working with Hibernate’s Entity Manager
 * In a nutshell, running CRUD operations on user objects is much easier than one might think. The entire process just boils down to spawning the EntityManager and consuming its API. It’s really that easy.
 *
 * For instance, we could use the application’s entry point, which is a simple class with a plain static main method, and call the entity manager in the following way:
 */
package application;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeDAO {
    public static void main(String[] args) {

        EntityManager entityManager = Persistence
                .createEntityManagerFactory("D++")
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        /* Persist a User entity */
        entityTransaction.begin();
        Employee user = new Employee("Alejandro", 24);
        entityManager.persist(user);
        entityTransaction.commit();

        /* Fetch a User entity */
        entityManager.find(Employee.class, 1);

        /* Update a User entity */
        entityTransaction.begin();
        user = entityManager.find(Employee.class, 1);
        user.setName("Alex");
        user.setAge(33);
        entityManager.merge(user);
        entityTransaction.commit();

        /* Remove a User entity */
        entityTransaction.begin();
        user = entityManager.find(Employee.class, 1);
        entityManager.remove(user);
        entityTransaction.commit();

        entityManager.close();
    }

}
