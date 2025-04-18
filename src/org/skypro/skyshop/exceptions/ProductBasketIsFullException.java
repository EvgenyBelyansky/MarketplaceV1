package org.skypro.skyshop.exceptions;

import org.skypro.skyshop.product.Product;

public class ProductBasketIsFullException extends RuntimeException{

    public ProductBasketIsFullException(Product product) {
        super(String.format("Корзина заполнена! Невозможно добавить продукт %s.", product.getProductName()));
    }
}
