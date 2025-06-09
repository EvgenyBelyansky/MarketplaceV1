package org.skypro.skyshop.product.productService;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class SearchEngine implements Comparator<Searchable>{

    private Set<Searchable> searchables;


    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String searchQuery) {
        Set<Searchable> searc1 = new HashSet<>();

        for (Searchable searchable : searchables) {
            if (searchable.searchTerm().toUpperCase().contains(searchQuery.toUpperCase())) {
                searc1.add(searchable);
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

    @Override
    public int compare(Searchable s1, Searchable s2) {
        final int lengthCompare = s1.getName().length() - s2.getName().length();

        if (lengthCompare == 0) {
            return s1.getName().compareTo(s2.getName());
        }
        return lengthCompare;
    }

}
