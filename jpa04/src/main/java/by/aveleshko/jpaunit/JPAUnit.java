package by.aveleshko.jpaunit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAUnit implements AutoCloseable {

    private EntityManagerFactory emFactory;

    public JPAUnit(String unitName) {
        emFactory = Persistence.createEntityManagerFactory(unitName);
    }

    public void runTransaction(JPATransactionAction action) {
        EntityManager entityManager = null;

        try {
            entityManager = emFactory.createEntityManager();
            EntityTransaction transaction = null;

            try {
                transaction = entityManager.getTransaction();
                transaction.begin();
                action.run(entityManager);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw e;
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void close() {
        emFactory.close();
    }

}
