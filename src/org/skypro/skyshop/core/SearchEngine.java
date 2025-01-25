package org.skypro.skyshop.core;

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
}
