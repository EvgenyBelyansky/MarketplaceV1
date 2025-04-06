package org.skypro.skyshop.product.specialProducts;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.productService.Searchable;

public class FixPriceProduct extends Product{

    private static final int FIX_PRODUCT_PRICE = 50;

    public FixPriceProduct(String productName, Article article) {
        super(productName, article);
    }

    @Override
    public double getPrice() {
        return FIX_PRODUCT_PRICE;
    }

    @Override
    public String toString() {
        return String.format("<%s>: Фиксированная цена <%s> рублей", getProductName(), getPrice());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


}
