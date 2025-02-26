package org.skypro.skyshop.basket;

public class ProductBasketIsFullExeption extends RuntimeException{
    public ProductBasketIsFullExeption() {
        super("Корзина заполнена! Невозможно добавить продукт.");
    }

}
