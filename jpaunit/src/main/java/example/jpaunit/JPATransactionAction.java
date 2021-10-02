package example.jpaunit;

import jakarta.persistence.EntityManager;

@FunctionalInterface
public interface JPATransactionAction {
    void run(EntityManager entityManager);
}
