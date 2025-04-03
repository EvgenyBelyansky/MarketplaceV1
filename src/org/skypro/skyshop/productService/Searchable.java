package org.skypro.skyshop.productService;

public interface Searchable {

    String searchTerm();

    String getTypeContent();

    String getNameContent();

    default String getStringRepresentation(Searchable searchable) {
        return searchable.getNameContent() + searchable.getTypeContent();
    }
}
