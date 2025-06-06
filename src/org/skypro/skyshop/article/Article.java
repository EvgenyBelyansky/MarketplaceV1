package org.skypro.skyshop.article;

import org.skypro.skyshop.product.productService.Searchable;

public class Article implements Searchable {
    private String articleName;

    private String articleDescription;

    public Article(String articleName, String articleDescription) {
        this.articleName = articleName;
        this.articleDescription = articleDescription;
    }

    @Override
    public String searchTerm() {
        return articleName + '\n' + articleDescription;
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return articleName + '\n' + articleDescription;
    }

    @Override
    public String getName() {
        return articleName;
    }
}
