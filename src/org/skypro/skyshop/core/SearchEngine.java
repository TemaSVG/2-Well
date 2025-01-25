package org.skypro.skyshop.core;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.ISearchable;

public class SearchEngine {
    ISearchable searchable[];

    public SearchEngine(int RangeArr) {
        searchable = new ISearchable[RangeArr];
    }

    public ISearchable[] search(String search) {
        ISearchable[] result = new ISearchable[5];
        int i = 0;
        for (ISearchable Searchable : this.searchable) {
            if (Searchable.searchTerm().toLowerCase().contains(search.toLowerCase())) {
                result[i] = Searchable;
                i++;
                if (i > 4) {
                    break;
                }
            }
        }
        return result;
    }

    public void add(ISearchable elem) {
        ISearchable[] buff = new ISearchable[searchable.length + 1];
        for (int i = 0; i < searchable.length; i++) {
            buff[i] = searchable[i];
        }
        buff[buff.length - 1] = elem;
        searchable = buff;
    }

    public ISearchable findTheMostSuitable(String search) throws BestResultNotFound{
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
