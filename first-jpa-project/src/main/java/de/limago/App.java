package de.limago;

import de.limago.entities.*;

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

        //persistDemo(entityManagerFactory);


        //finderDemo(entityManagerFactory);



        //mergeDemo(entityManagerFactory);

        //removeDemo(entityManagerFactory);

        EntityManager em = null;
        try {
            // Öffnet die Session. Zugeordnet ist immer first-level-cache
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

//            final HundEntity fiffi = HundEntity.builder().id(UUID.randomUUID().toString()).name("Fiffy").anzahlBellen(3).build();
//            em.persist(fiffi);

            AbstractTier fiffi = em.find(AbstractTier.class, "09866ac3-7e0c-42fd-aead-bb67490e3c61");
            System.out.println(fiffi);

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
            final var nonAttached = PersonEntity.builder().id("d1eb623d-5d72-4951-a98f-1e2eef167600").vorname("Erika").nachname("Mustermann").version(1).build();


            var attachedPerson = em.merge(nonAttached);  // Save or Update

            attachedPerson.setNachname("Mustermann");

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

    private void finderDemo(EntityManagerFactory entityManagerFactory) {
        //persistDemo(entityManagerFactory);
        EntityManager em = null;
        PersonEntity p=null;
        try {
            // Öffnet die Session. Zugeordnet ist immer first-level-cache
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            p = em.find(PersonEntity.class,"a4eba677-2c2d-45a6-aad3-d9114273a659" );
            p = em.find(PersonEntity.class,"a4eba677-2c2d-45a6-aad3-d9114273a659" );


            System.out.println(p);
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

        john.getAdresse().setOrt("Frankfurt");
        john.getAdresse().setStrasse("Die Zeil");

        Kontakt k;
        john.getKontakte().add(k = new Kontakt("email","max@atruvia.de"));
        john.getKontakte().add(new Kontakt("web","www.atruvia.de"));
        // guenstig
        EntityManager em = null;
        try {
            // Öffnet die Session. Zugeordnet ist immer first-level-cache
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            // Macht John attached
            em.persist(john);
            System.out.println(john);
            john.setVorname("xxx");

            //john.getKontakte().remove(k);
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

        // John ist detached
        john.setVorname("Max");
    }
}
