package by.aveleshko.jpa01.jpaunit;

import jakarta.persistence.EntityManager;

public interface JPATransactionAction {
    void run(EntityManager entityManager);
}
