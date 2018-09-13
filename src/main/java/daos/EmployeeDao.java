/**
 * a DAO class will encapsulate the handling of the entity manager and the entity transaction behind the
 * fences of a declarative API.
 */

package daos;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class EmployeeDao {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public void persist(String name, int age) {
        beginTransaction();
        Employee user = new Employee(name, age);
        entityManager.persist(user);
        commitTransaction();
    }

    public Employee find(int id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAllEmployee() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return (List<Employee>) query.getResultList();
    }

    public void update(int id, String name, int age) {
        beginTransaction();
        Employee user = entityManager.find(Employee.class, id);
        user.setName(name);
        user.setAge(age);
        entityManager.merge(user);
        commitTransaction();
    }

    public void remove(int id) {
        beginTransaction();
        Employee user = entityManager.find(Employee.class, id);
        entityManager.remove(user);
        commitTransaction();
    }

    private void beginTransaction() {
        try {
            entityTransaction.begin();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void commitTransaction() {
        try {
            entityTransaction.commit();
            entityManager.close();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}