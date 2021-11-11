package util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static HibernateUtil instance = null;

    private EntityManager entityManager;

    private HibernateUtil() {

        entityManager = Persistence
                .createEntityManagerFactory("clothing-management-hibernate-ogm-with-rmi-server")
                .createEntityManager();
    }

    public synchronized static HibernateUtil getInstance() {
        if (instance == null)
            instance = new HibernateUtil();

        return instance;
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }
}
