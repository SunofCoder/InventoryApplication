package com.senem.inventory.service;

import com.senem.inventory.models.Inventory;
import com.senem.inventory.models.Product;
import com.senem.inventory.models.User;
import com.senem.inventory.payload.request.InventoryRequest;
import com.senem.inventory.payload.request.UpdateStockRequest;
import com.senem.inventory.repository.InventoryRepository;
import com.senem.inventory.repository.ProductRepository;
import com.senem.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    private final UserRepository userRepository;


    private final ProductRepository productRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.inventoryRepository = inventoryRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<Inventory> getInventoryListByUsername(String username) {
        User loggedInUser = userRepository.findByUsername(username).orElse(null);
        return inventoryRepository.findAllByUserId(loggedInUser.getId());
    }

    public void removeProductFromInventory(String username, int productId) {
        User loggedInUser = userRepository.findByUsername(username).orElse(null);
        inventoryRepository.deleteByUserIdAndProductId(loggedInUser.getId(), productId);
    }

    public void addInventory(String username, InventoryRequest inventoryRequest){
        User loggedInUser = userRepository.findByUsername(username).orElse(null);
        Inventory inventory = new Inventory();
        inventory.setAmount(inventoryRequest.getAmount());
        inventory.setUser(loggedInUser);
        Product product = productRepository.findById(inventoryRequest.getProductId());
        inventory.setProduct(product);
        inventoryRepository.saveAndFlush(inventory);
    }

    public void updateInventory(String username, UpdateStockRequest updateStockRequest) {
        Inventory inventory = inventoryRepository.findById((long) updateStockRequest.getInventoryId()).orElse(null);
        inventory.setAmount(updateStockRequest.getAmount());
        inventoryRepository.saveAndFlush(inventory);
    }
}
