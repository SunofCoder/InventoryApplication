package com.senem.inventory.controller;

import com.senem.inventory.models.Inventory;
import com.senem.inventory.payload.request.InventoryRequest;
import com.senem.inventory.payload.request.UpdateStockRequest;
import com.senem.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getInventoryList(HttpServletRequest request) {
        String loggedInUsername = "test";//request.getUserPrincipal().getName();
        return new ResponseEntity<>(inventoryService.getInventoryListByUsername(loggedInUsername), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewProductToInventory(HttpServletRequest request, @RequestBody InventoryRequest inventoryRequest) {
        String loggedInUsername = "test";//request.getUserPrincipal().getName();
        inventoryService.addInventory(loggedInUsername, inventoryRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<?> removeProduct(HttpServletRequest request, @PathVariable int productId) {
        String loggedInUsername = "test";//request.getUserPrincipal().getName();
        inventoryService.removeProductFromInventory(loggedInUsername, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateInventory(HttpServletRequest request, @PathVariable UpdateStockRequest updateStockRequest) {
        String loggedInUsername = "test";//request.getUserPrincipal().getName();
        inventoryService.updateInventory(loggedInUsername, updateStockRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
