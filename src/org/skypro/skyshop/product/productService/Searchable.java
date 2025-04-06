package org.skypro.skyshop.product.productService;

public interface Searchable {

    String searchTerm();

    String getTypeContent();


    default String getStringRepresentation() {
        return String.format("Имя %s - тип %s", searchTerm(), getTypeContent());
    }

}
