package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.exceptions.ProductNameIsEmptyException;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.specialProducts.DiscountedProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.specialProducts.FixPriceProduct;
import org.skypro.skyshop.product.productService.SearchEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class App {
    public static void main(String[] args) {

        ProductBasket productBasketN1 = new ProductBasket();


        Article appleArticle = new Article(
                "О Яблоке", "Оно зеленое или красное, кислое или сладкое"
        );
        Article breadArticle = new Article(
                "Что-то про Хлеб", "Бывает черрный и белый"
        );
        Article milkArticle = new Article(
                "Про молоко", "Жидкое и белое......."
        );
        Article sausageArticle = new Article(
                "Про Колбасу", "Из мяса, возможно"
        );
        Article lollipopArticle = new Article(
                "Про Леденец", "На палке и нет"
        );


        Product apple = new FixPriceProduct(
                "Яблоко"
        );
        Product bread = new SimpleProduct(
                "Яблоко", 25
        );
        Product milk = null;
        try {
            milk = new SimpleProduct(
                    "Молоко", 120
            );
        } catch (ProductNameIsEmptyException e) {
            e.printStackTrace();
        }
        Product sausage = null;
        try {
            sausage = new SimpleProduct(
                    "Колбаса", 250
            );
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        Product lollipop = new DiscountedProduct(
                "Леденец", 13, 35
        );


        //Добавление товаров разных типов в корзину
        System.out.println("\n<<Добавление товаров разных типов в корзину>>");
        productBasketN1.addProdukt(apple);
        productBasketN1.addProdukt(bread);
        productBasketN1.addProdukt(milk);
        productBasketN1.addProdukt(sausage);
        productBasketN1.addProdukt(lollipop);

        //Распечатка товаров в корзине
        System.out.println("---------------------------------");
        System.out.println("\n<<Распечатка всех товаров в корзине>>");
        try {
            productBasketN1.printAllProductsInBasket();
        } catch (NullPointerException e) {
            System.out.println("Один из продуктов не создан, проверь корзину!!" + Arrays.toString(e.getStackTrace()));
        }
        System.out.println("---------------------------------");


        SearchEngine newSearch = new SearchEngine();
        newSearch.add(apple);
        newSearch.add(apple);
        newSearch.add(milk);
        newSearch.add(sausage);
        newSearch.add(lollipop);
        newSearch.add(sausageArticle);
        newSearch.add(milkArticle);
        newSearch.add(breadArticle);
        newSearch.add(lollipopArticle);


        System.out.println("---------------------------------");
        try {
            System.out.println(newSearch.search("колб"));
        } catch (NullPointerException e) {
            System.out.println("Один из продуктов не создан, проверь корзину!!" + Arrays.toString(e.getStackTrace()));
        }
        System.out.println("---------------------------------");

        System.out.println();
        System.out.println("Метод поиска лучшего варианта(объект существует)");
        System.out.println("---------------------------------");
        System.out.println(newSearch.validBestMatch("Яблок"));
        System.out.println("---------------------------------");


        System.out.println();
        System.out.println("Метод поиска лучшего варианта(объект не существует)");
        System.out.println("---------------------------------");
        try {
            System.out.println(newSearch.validBestMatch("GHBKEHF"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        System.out.println("---------------------------------");
        System.out.println("\n\n");


        System.out.println("---------------------------------");
        System.out.println("Удаленные продукты:");
        System.out.println(productBasketN1.removeProduct("Яблоко"));
        System.out.println("---------------------------------");
        System.out.println();

        System.out.println("---------------------------------");
        productBasketN1.printAllProductsInBasket();

        System.out.println("---------------------------------");
        System.out.println(productBasketN1.removeProduct("Яблоко"));
        System.out.println("---------------------------------");

    }
}