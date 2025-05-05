package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {

    private final List<Product> productBasket;


    public ProductBasket() {
        this.productBasket = new ArrayList<>();
    }

    public void addProdukt(Product product) {
        productBasket.add(product);
    }

    public List removeProduct(String removedProductName) {
        List<Product> removedProducts = new ArrayList<>();

        for (int i = 0; i < productBasket.size(); i++) {
            if (removedProductName.equals(productBasket.get(i).getProductName())) {
                removedProducts.add(productBasket.get(i));
                productBasket.remove(i);
            }
        }

        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removedProducts;
    }

    public int summingBasketPrice() {
        int sum = 0;
        for (int i = 0; i < productBasket.size(); i++) {
            sum += productBasket.get(i).getPrice();
        }
        return sum;
    }

    public void printAllProductsInBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("«В корзине пусто»");
            return;
        }

        for (int i = 0; i < productBasket.size(); i++) {
            System.out.println(productBasket.get(i));
//
        }
        System.out.printf("\nИтого: <%s>%n", summingBasketPrice());
        System.out.printf("Специальных товаров: <%s>%n",
                productBasket.stream()
                        .filter(Product::isSpecial)
                        .count());
    }

    public void clearBasket() {
        productBasket.removeAll(productBasket);
    }

    public boolean findProductForName(String productName) {
        for (Product product : productBasket) {
            if (productBasket.isEmpty()) {
                System.out.println("«В корзине пусто»");
                break;
            } else if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }
}
