package com.senem.inventory.payload.request;

public class UpdateStockRequest {
    private int amount;

    private int inventoryId;

    public UpdateStockRequest(int amount, int inventoryId) {
        this.amount = amount;
        this.inventoryId = inventoryId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }
}
