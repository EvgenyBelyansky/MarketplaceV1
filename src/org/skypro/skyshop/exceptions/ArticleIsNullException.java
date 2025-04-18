package org.skypro.skyshop.exceptions;

public class ArticleIsNullException extends RuntimeException {

    public ArticleIsNullException(String productName) {

        super(String.format("Статья про продукт $s не создана. Создайте статью!", productName));
    }
}
