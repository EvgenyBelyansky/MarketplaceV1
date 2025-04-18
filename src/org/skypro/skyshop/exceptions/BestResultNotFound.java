package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends RuntimeException {
    public BestResultNotFound() {
        super("Для поискового запроса не нашлось подходящей статьи.");
    }
}
