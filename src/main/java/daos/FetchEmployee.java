package daos;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchEmployee {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("D++");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        /* Fetch a User entity */
        Employee employee = em.find(Employee.class, 21);
        System.out.println(employee);
        tx.commit();


        em.close();
        emf.close();


    }

}
