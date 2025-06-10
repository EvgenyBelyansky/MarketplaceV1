package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {


    private final Map<String, List<Product>> productBasket;


    public ProductBasket() {
        this.productBasket = new HashMap<>();
    }

    public void addProdukt(Product product) {
        checkProductExist(product);

        productBasket.computeIfAbsent(
                product.getName(), k -> new ArrayList<>()).add(product);
    }

    private void checkProductExist(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
    }


    public List<Product> removeProduct(String removedProductName) {

        return productBasket.remove(removedProductName);
    }

    public double summingBasketPrice() {

        return productBasket.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void printAllProductsInBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("«В корзине пусто»");
            return;
        }

        final long count = productBasket.values().stream()
                .peek(System.out::println)
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
        System.out.printf("Специальных товаров: <%s>%n", count);
    }


    public void clearBasket() {
        productBasket.clear();
    }

    public boolean findProductForName(String productName) {
        return productBasket.containsKey(productName);
    }
}
