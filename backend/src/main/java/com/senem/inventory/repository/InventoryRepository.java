package com.senem.inventory.repository;

import com.senem.inventory.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findAllByUserId(Long userId);

    void deleteByUserIdAndProductId(Long userId, int productId);
}
