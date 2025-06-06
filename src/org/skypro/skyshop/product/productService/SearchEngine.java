package org.skypro.skyshop.product.productService;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class SearchEngine {

    private List<Searchable> searchables;


    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String,Searchable> search(String searchQuery) {
        Map<String,Searchable> searc1 = new TreeMap<>();

        for (Searchable searchable : searchables) {
            if (searchable.searchTerm().toUpperCase().contains(searchQuery.toUpperCase())) {
                searc1.put(searchable.getName() ,searchable);
            }
        }
        return searc1;
    }

    public Searchable validBestMatch(String search) {

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable == null) {
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
}
