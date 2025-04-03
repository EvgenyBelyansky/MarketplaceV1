package org.skypro.skyshop.article;

import org.skypro.skyshop.productService.Searchable;

public class Article implements Searchable {
    private final String articleName;

    private final String articleBody;

    public Article(String articleName, String articleBody) {
        this.articleName = articleName;
        this.articleBody = articleBody;
    }

    @Override
    public String searchTerm(String searchableText) {
        return searchableText;
    }

    @Override
    public String getTypeContent() {
        return "";
    }

    @Override
    public String getNameContent() {
        return "";
    }

    @Override
    public String toString() {
        return  articleName + '\n' + articleBody;
    }
}
