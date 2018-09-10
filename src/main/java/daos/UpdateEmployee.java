package daos;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateEmployee {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("D++");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Employee updateEmployee = em.find(Employee.class, 19);
        updateEmployee.setName("Alex");
        updateEmployee.setAge(33);

        em.persist(updateEmployee);
        tx.commit();


        em.close();
        emf.close();
        System.out.println("Employee updated and saved.");


    }
}