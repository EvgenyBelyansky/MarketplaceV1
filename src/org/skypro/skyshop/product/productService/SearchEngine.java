package org.skypro.skyshop.product.productService;

import java.util.Arrays;

public class SearchEngine {

    private Searchable[] searchables;
    private int count;


    public SearchEngine(int count) {
        this.searchables = new Searchable[count];
    }

    public void add(Searchable searchable) {
        searchables[count++] = searchable;
    }

    public Searchable[] search(String searchQuery) {
        Searchable[] searc1 = new Searchable[5];
        int newCount = 0;
        for (int i = 0; i < count; i++) {
            if (searchables[i].searchTerm().toUpperCase().contains(searchQuery.toUpperCase())) {
                searc1[newCount] = searchables[i];
                newCount++;
            }
            if (searc1.length < 5) {
                break;
            }

        }
        return searc1;
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchables=" + Arrays.toString(searchables) +
                '}';
    }
}
