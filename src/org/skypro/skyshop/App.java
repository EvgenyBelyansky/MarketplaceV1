package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;


public class App {
    public static void main(String[] args) {


        ProductBasket productBasketN1 = new ProductBasket();

        productBasketN1.addProdukt(
                new Product("Яблоко", 50)
        );
        productBasketN1.addProdukt(
                new Product("Хлеб", 25)
        );
        productBasketN1.addProdukt(
                new Product("Молоко", 120)
        );
        productBasketN1.addProdukt(
                new Product("Колбаса", 250)
        );
        productBasketN1.addProdukt(
                new Product("Леденец", 13)
        );

        //Вычисление стоимости товаров в корзине
        System.out.println("Сумма товаров в корзине = " + productBasketN1.summingBasketPrice());

        //Распечатка всех товаров в корзине
        productBasketN1.printAllProductsInBasket();

        //Поиск продукта в корзине по названию
        System.out.println(productBasketN1.findProductForName("Батон"));
        System.out.println(productBasketN1.findProductForName("Яблоко"));

        //Очистка корзины
        productBasketN1.clearBasket();
        productBasketN1.printAllProductsInBasket();


    }
}