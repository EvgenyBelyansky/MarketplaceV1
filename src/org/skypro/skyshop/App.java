package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.specialProducts.DiscountedProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.specialProducts.FixPriceProduct;
import org.skypro.skyshop.product.productService.SearchEngine;

import java.util.Arrays;


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
                "Яблоко",
                appleArticle
        );
        Product bread = new DiscountedProduct(
                "Хлеб", 25, 50,
                breadArticle
        );
        Product milk = new SimpleProduct(
                "Молоко", 120,
                milkArticle
        );
        Product sausage = new SimpleProduct(
                "Колбаса", 250,
                sausageArticle
        );
        Product lollipop = new DiscountedProduct(
                "Леденец", 13, 35,
                lollipopArticle
        );


        //Добавление товаров разных типов в корзину
        System.out.println("\n<<Добавление товаров разных типов в корзину>>");
        productBasketN1.addProdukt(apple);
        productBasketN1.addProdukt(bread);
        productBasketN1.addProdukt(milk);
        productBasketN1.addProdukt(sausage);
        productBasketN1.addProdukt(lollipop);

        //Распечатка товаров в корзине
        System.out.println("\n<<Распечатка всех товаров в корзине>>");
        productBasketN1.printAllProductsInBasket();


        SearchEngine newSearch = new SearchEngine(10);
        newSearch.add(apple);
        newSearch.add(appleArticle);
        newSearch.add(milk);
        newSearch.add(sausage);
        newSearch.add(lollipop);
        newSearch.add(sausageArticle);
        newSearch.add(milkArticle);
        newSearch.add(breadArticle);
        newSearch.add(lollipopArticle);

        System.out.println(Arrays.toString(newSearch.search("Леде")));


    }
}