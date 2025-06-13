package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends RuntimeException {
    public BestResultNotFound(String searchText) {
        super("Для поискового запроса |%s| не нашлось подходящей статьи.".formatted(searchText));
    }
}
