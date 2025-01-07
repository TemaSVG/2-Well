package org.skypro.skyshop.core;

import org.skypro.skyshop.product.ISearchable;

public class SearchEngine {
    ISearchable Searchable[];

    public SearchEngine(int RangeArr) {
        Searchable = new ISearchable[RangeArr];
    }

    public ISearchable[] search(String search) {
        ISearchable[] result = new ISearchable[5];
        int i = 0;
        for (ISearchable Searchable : this.Searchable) {
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
        ISearchable[] buff = new ISearchable[Searchable.length + 1];
        for (int i = 0; i < Searchable.length; i++) {
            buff[i] = Searchable[i];
        }
        buff[buff.length - 1] = elem;
        Searchable = buff;
    }
}
