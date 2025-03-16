package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasketIsFullExeption extends RuntimeException{
    public ProductBasketIsFullExeption(Product product) {
        super(String.format("Корзина заполнена! Невозможно добавить продукт %s.", product.getProductName()));
    }
}
