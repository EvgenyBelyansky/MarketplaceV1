package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.exceptions.ArticleIsNullException;
import org.skypro.skyshop.exceptions.ProductNameIsEmptyException;
import org.skypro.skyshop.product.productService.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    private final String productName;


    public Product(String productName) {
        validProductName(productName);

        this.productName = productName;
    }

    private void validProductName(String prodName) {
        if (prodName == null || prodName.isBlank()) {
            throw new ProductNameIsEmptyException();
        }
    }

    private void validArticle(Article art) {
        if (art == null) {
            throw new ArticleIsNullException(productName);
        }
    }

    public String getName() {
        return productName;
    }

    public abstract double getPrice();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }

    @Override
    public String toString() {
        return String.format("<%s>: <%s>", productName, getPrice());
    }

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return productName;
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

}
