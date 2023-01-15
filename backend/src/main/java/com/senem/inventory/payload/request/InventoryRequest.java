package com.senem.inventory.payload.request;

public class InventoryRequest {
    private int amount;

    private int userId;

    private int productId;

    public InventoryRequest(int amount, int userId, int productId) {
        this.amount = amount;
        this.userId = userId;
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
