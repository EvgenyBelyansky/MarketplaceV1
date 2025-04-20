package org.skypro.skyshop.exceptions;

import org.skypro.skyshop.product.Product;

public class ProductBasketIsFullException extends RuntimeException{

    public ProductBasketIsFullException(Product product) {
        super("Корзина заполнена! Невозможно добавить продукт %s.".formatted(product.getProductName()));
    }
}
