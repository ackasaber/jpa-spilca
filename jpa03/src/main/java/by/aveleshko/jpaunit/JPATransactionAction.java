package by.aveleshko.jpaunit;

import jakarta.persistence.EntityManager;

public interface JPATransactionAction {
    void run(EntityManager entityManager);
}
