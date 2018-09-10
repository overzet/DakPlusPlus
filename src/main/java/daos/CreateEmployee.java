package daos;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateEmployee {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("D++");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        /* Persist a User entity */
        Employee createEmployee = new Employee("Alejandro", 24);


        em.persist(createEmployee);
        tx.commit();


        em.close();
        emf.close();
        System.out.println("New employee saved.");


    }

}
