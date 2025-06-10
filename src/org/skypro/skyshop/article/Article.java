package org.skypro.skyshop.article;

import org.skypro.skyshop.product.productService.Searchable;

import java.util.Objects;

public class Article implements Searchable, Comparable<Searchable>{
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleName);
    }

    @Override
    public int compareTo(Searchable o) {

        int lengthCompare = Integer.compare(
                o.getName().length(),
                this.getName().length()
        );

        if (lengthCompare == 0) {
            return this.getName().compareTo(o.getName());
        }
        return lengthCompare;
    }
}
