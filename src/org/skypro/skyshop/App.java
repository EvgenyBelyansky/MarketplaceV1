package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.specialProducts.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;


public class App {
    public static void main(String[] args) {

        ProductBasket productBasketN1 = new ProductBasket();

        productBasketN1.addProdukt(
                new SimpleProduct("Яблоко", 50)
        );
        productBasketN1.addProdukt(
                new SimpleProduct("Хлеб", 25)
        );
        productBasketN1.addProdukt(
                new SimpleProduct("Молоко", 120)
        );
        productBasketN1.addProdukt(
                new SimpleProduct("Колбаса", 250)
        );
        productBasketN1.addProdukt(
                new SimpleProduct("Леденец", 13)
        );

        //Вычисление стоимости товаров в корзине
        System.out.println("\n<<Вычисление стоимости товаров в корзине>>");
        System.out.println("Сумма товаров в корзине = " + productBasketN1.summingBasketPrice());

        //Распечатка всех товаров в корзине
        System.out.println("\n<<Распечатка всех товаров в корзине>>");
        productBasketN1.printAllProductsInBasket();

        //Поиск по названию, продукта, который есть в корзине
        System.out.println("\n<<Поиск по названию, продукта, который есть в корзине>>");
        System.out.println(productBasketN1.findProductForName("Яблоко"));

        //Поиск по названию, продукта, которого нет в корзине
        System.out.println("\n<<Поиск по названию, продукта, которого нет в корзине>>");
        System.out.println(productBasketN1.findProductForName("Батон"));

        //Очистка корзины
        System.out.println("\n<<Очистка корзины>>");
        productBasketN1.clearBasket();

        //Распечатка пустой корзины
        System.out.println("\n<<Распечатка пустой корзины>>");
        productBasketN1.printAllProductsInBasket();

        //Вычисление суммы пустой корзины
        System.out.println("\n<<Вычисление суммы пустой корзины>>");
        System.out.println(productBasketN1.summingBasketPrice());

        //Поиск продукта в пустой корзине по названию
        System.out.println("\n<<Поиск продукта в пустой корзине по названию>>");
        System.out.println(productBasketN1.findProductForName("Яблоко"));

        //Добавление товара в заполненную корзину
        System.out.println("\n<<Добавление товара в заполненную корзину>>");
        productBasketN1.addProdukt(
                new SimpleProduct("Яблоко", 50)
        );
        productBasketN1.addProdukt(
                new SimpleProduct("Хлеб", 25)
        );
        productBasketN1.addProdukt(
                new SimpleProduct("Молоко", 120)
        );
        productBasketN1.addProdukt(
                new SimpleProduct("Колбаса", 250)
        );
        productBasketN1.addProdukt(
                new SimpleProduct("Леденец", 13)
        );

        Product d1 = new DiscountedProduct("Apple", -50, 100);
        System.out.println(d1.getPrice());
    }
}