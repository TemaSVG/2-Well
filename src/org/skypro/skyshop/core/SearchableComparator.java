package org.skypro.skyshop.core;

import org.skypro.skyshop.product.ISearchable;

import java.util.Comparator;

public class SearchableComparator implements Comparator<ISearchable> {

    public int compare(ISearchable s1, ISearchable s2) {
        int lengthComparison = Integer.compare(s2.searchTerm().length(), s1.searchTerm().length());
        return lengthComparison != 0 ? lengthComparison : s1.searchTerm().compareTo(s2.searchTerm());
    }
}
