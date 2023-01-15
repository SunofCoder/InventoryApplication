package com.senem.inventory.payload.request;

import com.senem.inventory.models.Product;

public class ProductRequest {
    private Product product;

    public ProductRequest(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
