package org.skypro.skyshop.core;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.ISearchable;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {
    private Set<ISearchable> searchable;

    public SearchEngine() {
        this.searchable = new HashSet<>();
    }

    public Set<ISearchable> search(String search) {
        Set<ISearchable> result = new TreeSet<>(Comparator.comparing(ISearchable::searchTerm));
        String[] searchTerm = search.toLowerCase().split(" ");

        for (ISearchable Searchable : searchable) {
            boolean coincidences = true;
            for (String term : searchTerm)
                if (!Searchable.searchTerm().toLowerCase().contains(term)) {
                    coincidences = false;
                    break;
                }
            if (coincidences) {
                result.add(Searchable);
            }
        }
        return result;
    }

    public void add(ISearchable elem) {
            searchable.add(elem);
    }

    public Set<ISearchable> getSortedResult() {
        Set<ISearchable> sortedResults = new TreeSet<>(new SearchableComparator());
        sortedResults.addAll(searchable);
        return sortedResults;
    }

    public ISearchable findTheMostSuitable(String search) throws BestResultNotFound {
        if (searchable.toString().isEmpty()) {
            throw new IllegalArgumentException("Объект поиска не может быть пустым");
        }
        if (search == null || search.isBlank()) {
            throw new IllegalArgumentException("Строка для поиска не может быть null или пустой");
        }

        ISearchable mostSuitable = null;
        int maxCount = 0;

        for (ISearchable Searchable : this.searchable) {
            int count = countOccurrences(Searchable.searchTerm(), search);

            if (count > maxCount) {
                maxCount = count;
                mostSuitable = Searchable;
            }
        }

        if (mostSuitable == null) {
            throw new BestResultNotFound(search);
        }
        return mostSuitable;
    }

    private int countOccurrences(String searchTerm, String search) {
        int count = 0;
        int index = 0;
        while ((index = searchTerm.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }
        return count;
    }
}
