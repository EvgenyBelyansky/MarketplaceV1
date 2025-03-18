package org.skypro.skyshop.product.specialProducts;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class DiscountedProduct extends Product {

    private double discountPercentage;
    private double basePrice;

    public DiscountedProduct(String productName, int discountPercentage, int basePrice) {
        super(productName);
        this.discountPercentage = Math.abs(discountPercentage);
        this.basePrice = Math.abs(basePrice);
    }

    @Override
    public double getPrice() {
        return basePrice * (discountPercentage / 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return discountPercentage == that.discountPercentage && basePrice == that.basePrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountPercentage, basePrice);
    }

    @Override
    public String toString() {
        return String.format("<%s>: <%s>, (%s%% скидка) ", getProductName(), getPrice(), discountPercentage);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
