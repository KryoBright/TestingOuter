package com.example.test.test.integration;

import com.example.test.test.models.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.instancio.Instancio;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseStepProvider {

    private final EntityManagerFactory entityManagerFactory;
    <T> void saveEntity(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void deleteEmployees() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Employee WHERE 1=1").executeUpdate();
        entityManager.getTransaction().commit();
    }
}