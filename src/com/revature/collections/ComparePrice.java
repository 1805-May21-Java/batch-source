package com.revature.collections;

import java.util.Comparator;

public class ComparePrice implements Comparator<ChineseFood> {
    @Override
    public int compare(ChineseFood o1, ChineseFood o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
