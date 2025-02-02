package org.skypro.skyshop.core;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.ISearchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private List<ISearchable> searchable;

    public SearchEngine() {
        this.searchable = new ArrayList<>();
    }

    public Map<String, ISearchable> search(String search) {
        Map<String, ISearchable> result = new TreeMap<>();
        String[] searchTerm = search.toLowerCase().split(" ");

        for (ISearchable Searchable : searchable) {
            boolean coincidences = true;
            for (String term : searchTerm)
                if (!Searchable.searchTerm().toLowerCase().contains(term)) {
                    coincidences = false;
                    break;
                }
            if (coincidences) {
                result.put(Searchable.searchTerm(), Searchable);
            }
        }
        return result;
    }

    public void add(ISearchable elem) {
        searchable.add(elem);
    }

    public ISearchable findTheMostSuitable(String search) throws BestResultNotFound {
        if (searchable == null) {
            throw new IllegalArgumentException("Объект поиска нге может быть null");
        }
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
