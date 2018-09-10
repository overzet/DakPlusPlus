package daos;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteEmployee {

        public static void main(String[] args) {

            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("D++");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            /* Remove a User entity */
            Employee removeEmployee = em.find(Employee.class, 19);
            em.remove(removeEmployee);

            tx.commit();

            em.close();
            emf.close();
            System.out.println("Employee removed.");
        }

    }


