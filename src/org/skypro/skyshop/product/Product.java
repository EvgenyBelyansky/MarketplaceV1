package org.skypro.skyshop.product;

import org.skypro.skyshop.productService.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    private final String productName;


    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract double getPrice();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }

    @Override
    public String toString() {
        return String.format("<%s>: <%s>", productName, getPrice());
    }

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return productName;
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public String getNameContent() {
        return "";
    }
}
