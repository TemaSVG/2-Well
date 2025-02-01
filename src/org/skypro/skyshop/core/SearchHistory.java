package org.skypro.skyshop.core;

import java.util.ArrayList;
import java.util.List;

public class SearchHistory {
    private final List<String> history = new ArrayList<>();

    public void addQuery(String query) {
        history.add(query);
    }

    public List<String> getHistory() {
        return history;
    }

    public void printHistory() {
        System.out.println("История поисковых запросов:");
        for (String query : history) {
            System.out.println(query);
        }
    }
}
