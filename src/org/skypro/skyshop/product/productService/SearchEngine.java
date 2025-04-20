package org.skypro.skyshop.product.productService;

import org.skypro.skyshop.exceptions.BestResultNotFound;

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

    public Searchable validBestMatch(String search) {

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            if(searchable == null) {
                break;
            }
            String text = searchable.searchTerm();
            int count = countOccurrences(text.toUpperCase(), search.toUpperCase());

            if (count > maxCount) {
                maxCount = count;
                bestMatch = searchable;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String search) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }

        return count;
    }



    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchables=" + Arrays.toString(searchables) +
                '}';
    }



    public int getCount() {
        return count;
    }
}
