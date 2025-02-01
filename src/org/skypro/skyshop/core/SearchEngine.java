package org.skypro.skyshop.core;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.ISearchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchEngine {
    private final List<SearchObject> searchable;
    private final SearchHistory searchHistory;



    public SearchEngine() {
        this.searchable = new ArrayList<>();
        this.searchHistory = new SearchHistory();
    }

    public List<ISearchable> search(String search) {
        searchHistory.addQuery(search);
        List<ISearchable> result = new ArrayList<>();

        String[] searchTerms = search.toLowerCase().split(" ");

        for (SearchObject Searchable : searchable) {
            boolean coincidences = true;
            for (String term : searchTerms) {
                if (!Searchable.Searchable.searchTerm().toLowerCase().contains(term)) {
                    coincidences = false;
                    break;
                }
            }
            if (coincidences) {
                result.add(Searchable.Searchable);
            }
        }
        return result;
    }

    public void add(ISearchable elem) {
        SearchObject addObject = new SearchObject();
        addObject.Searchable = elem;
        searchable.add(addObject);
    }

    private void setFindIndex(String search) {
        for (SearchObject searchObject : searchable) {
            searchObject.FindIndex = countOccurrences(searchObject.Searchable.searchTerm(), search);
        }
    }

    private int getMaxIndex() {
        int maxCount = Integer.MIN_VALUE;
        for (SearchObject searchObject : searchable) {
            if (searchObject.FindIndex > maxCount) {
                maxCount = searchObject.FindIndex;
            }
        }
        return maxCount;
    }

    private int getMinIndex() {
        int minCount = Integer.MAX_VALUE;
        for (SearchObject searchObject : searchable) {
            if (searchObject.FindIndex < minCount && searchObject.FindIndex != 0) {
                minCount = searchObject.FindIndex;
            }
        }
        return minCount;
    }

    private int getMidIndex() {
        int sum = 0;
        for (SearchObject searchObject : searchable) {
            sum += searchObject.FindIndex;
        }
        return sum / searchable.size();
    }

    public ISearchable findTheMostSuitable(String search) throws BestResultNotFound {
        if (searchable.toString().isEmpty()) {
            throw new IllegalArgumentException("Объект поиска не может быть пустым");
        }
        if (search == null || search.isBlank()) {
            throw new IllegalArgumentException("Строка для поиска не может быть null или пустой");
        }

        searchHistory.addQuery(search);
        setFindIndex(search);

        int maxIndex = getMaxIndex();
        if (maxIndex == 0) {
            throw new BestResultNotFound(search);
        }

        Random random = new Random();
        ISearchable result = null;

        for (SearchObject searchObject : searchable) {
            if (maxIndex == searchObject.FindIndex) {
                if (result == null) {
                    result = searchObject.Searchable;
                }
                if (random.nextInt(100) < 50) {
                    result = searchObject.Searchable;
                }
            }
        }
        return result;
    }

    public List<ISearchable> getMaxMidMinIndex(String search) {
        setFindIndex(search);
        searchHistory.addQuery(search);
        List<ISearchable> minMidMax = new ArrayList<>();

        minMidMax.addAll(getElementsByIndex(getMaxIndex(), 3));
        minMidMax.addAll(getElementsByIndex(getMidIndex(), 3));
        minMidMax.addAll(getElementsByIndex(getMinIndex(), 3));

        return minMidMax;
    }

    private List<ISearchable> getElementsByIndex(int targetIndex, int limit) {
        List<ISearchable> result = new ArrayList<>();
        int count = 0;
        for (SearchObject searchObject : searchable) {
            if (searchObject.FindIndex == targetIndex && count < limit) {
                result.add(searchObject.Searchable);
                count++;
            }
        }
        return result;
    }

    private int countOccurrences(String main, String sub) {
        int count = 0;
        int index = 0;
        while ((index = main.toLowerCase().indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    public void printSearchHistory() {
        searchHistory.printHistory();
    }

}

