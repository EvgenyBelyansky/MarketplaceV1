package org.skypro.skyshop.product.specialProducts;

import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {

    private static final int FIX_PRODUCT_PRICE = 50;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public double getPrice() {
        return FIX_PRODUCT_PRICE;
    }

    @Override
    public String toString() {
        return String.format("Продукт c фиксированной ценой %s стоит %s рублей", getProductName(), getPrice());
    }
}
