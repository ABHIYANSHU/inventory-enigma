package com.example.inventoryenigma.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class OrderService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void processOrder(String firstItemId, String secondItemId) {
        // Update rows in a specific order to trigger deadlock
        entityManager.createNativeQuery(
                "UPDATE inventory SET stock = stock - 1 WHERE id = ?"
        ).setParameter(1, firstItemId).executeUpdate();

        // Simulate delay to increase deadlock probability
        try { Thread.sleep(100); } catch (InterruptedException e) {}

        entityManager.createNativeQuery(
                "UPDATE inventory SET stock = stock - 1 WHERE id = ?"
        ).setParameter(1, secondItemId).executeUpdate();
    }
}
