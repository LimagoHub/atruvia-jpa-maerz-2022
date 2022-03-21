package de.limago;

import com.arjuna.ats.internal.arjuna.recovery.Connection;
import de.limago.entities.PersonEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       new App().run();
    }

    private void run() {
        // Teuer
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("atruvia");

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Shutdown Hook is running !");
            entityManagerFactory.close();}
        ));


        //finderDemo(entityManagerFactory);


        //mergeDemo(entityManagerFactory);

        removeDemo(entityManagerFactory);


        System.out.println("fertig");
    }

    private void removeDemo(EntityManagerFactory entityManagerFactory) {
        EntityManager em = null;
        try {
            // Öffnet die Session. Zugeordnet ist immer first-level-cache
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            final PersonEntity john = em.find(PersonEntity.class, "3407df7f-eef8-4707-aac6-fafcd5e6dfeb");
            em.remove(john);

            em.getTransaction().commit();
        }
        catch(RuntimeException e) {
            e.printStackTrace();
            if (em != null)  em.getTransaction().rollback();
        }
        finally {
            // Vernichtet die Session und den Cache
            if (em != null) em.close();
        }
    }

    private void mergeDemo(EntityManagerFactory entityManagerFactory) {
        EntityManager em = null;
        try {
            // Öffnet die Session. Zugeordnet ist immer first-level-cache
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            final var nonAttached = PersonEntity.builder().id("3407df7f-eef8-4707-aac6-fafcd5e6dfeb").vorname("John").nachname("Wick").build();


            var attachedPerson = em.merge(nonAttached);  // Save or Update

            attachedPerson.setNachname("Mustermann");

            em.getTransaction().commit();
        }
        catch(RuntimeException e) {
            if (em != null)  em.getTransaction().rollback();
        }
        finally {
            // Vernichtet die Session und den Cache
            if (em != null) em.close();
        }
    }

    private void finderDemo(EntityManagerFactory entityManagerFactory) {
        //persistDemo(entityManagerFactory);
        EntityManager em = null;
        try {
            // Öffnet die Session. Zugeordnet ist immer first-level-cache
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            var p = em.find(PersonEntity.class,"3407df7f-eef8-4707-aac6-fafcd5e6dfea" );
            p.setVorname("Peter");

            em.getTransaction().commit();
        }
        catch(RuntimeException e) {
            if (em != null)  em.getTransaction().rollback();
        }
        finally {
            // Vernichtet die Session und den Cache
            if (em != null) em.close();
        }
    }

    private void persistDemo(EntityManagerFactory entityManagerFactory) {
        final var john = PersonEntity.builder().id(UUID.randomUUID().toString()).vorname("John").nachname("Doe").build();

        // guenstig
        EntityManager em = null;
        try {
            // Öffnet die Session. Zugeordnet ist immer first-level-cache
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            // Macht John attached
            em.persist(john);

            john.setVorname("Jane");
            em.getTransaction().commit();
        }
        catch(RuntimeException e) {
            if (em != null)  em.getTransaction().rollback();
        }
        finally {
            // Vernichtet die Session und den Cache
            if (em != null) em.close();
        }

        // John ist detached
        john.setVorname("Max");
    }
}
