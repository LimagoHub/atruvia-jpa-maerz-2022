package de.limago;

import de.limago.entities.Bar;
import de.limago.entities.Barkeeper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        // Teuer
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("atruvia");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown Hook is running !");
            entityManagerFactory.close();
        }
        ));
        Bar sonderbar = null;
        EntityManager em = null;
        try {
            // Öffnet die Session. Zugeordnet ist immer first-level-cache
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            sonderbar = em.find(Bar.class, "4567");
            System.out.println(sonderbar);

            //         System.out.println(sonderbar.getKeepers());
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (em != null) em.getTransaction().rollback();
        } finally {
            // Vernichtet die Session und den Cache
            if (em != null) em.close();
        }


    }
}
