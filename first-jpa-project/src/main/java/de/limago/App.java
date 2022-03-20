package de.limago;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("atruvia");

        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
                System.out.println("Shutdown Hook is running !");
                entityManagerFactory.close();
            }
        });
        System.out.println("fertig");
    }
}
