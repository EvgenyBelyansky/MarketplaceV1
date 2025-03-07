package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {

    private final Product[] productBasket;

    private int quantityProductsInBasket;


    public ProductBasket() {
        this.productBasket = new Product[5];
    }


    public void addProdukt(Product product) {
        if (quantityProductsInBasket >= productBasket.length) {
            throw new ProductBasketIsFullExeption();
        }
        productBasket[quantityProductsInBasket++] = product;
    }

    public int summingBasketPrice() {
        int sum = 0;
        for (int i = 0; i < quantityProductsInBasket; i++) {
            sum += productBasket[i].getPrice();
        }
        return sum;
    }

    public void printAllProductsInBasket() {
        if (quantityProductsInBasket == 0) {
            System.out.println("«В корзине пусто»");
            return;
        }

        for (int i = 0; i < quantityProductsInBasket; i++) {
            System.out.printf("<%s>: <%s>%n",
                    productBasket[i].getProductName(), productBasket[i].getPrice());
        }
        System.out.printf("\nИтого: <%s>%n", summingBasketPrice());
    }


    public void clearBasket() {
        Arrays.fill(productBasket, null);
        quantityProductsInBasket = 0;
    }

    public boolean findProductForName(String productName) {
        for (Product product : productBasket) {
            if (quantityProductsInBasket == 0) {
                System.out.println("«В корзине пусто»");
                break;
            } else if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }
}
