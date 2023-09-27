package com.metlife.facades;

import com.metlife.models.PolicyHolder;

import java.util.Comparator;

public class PolicyHolderSorter implements Comparator<PolicyHolder> {
    @Override
    public int compare(PolicyHolder o1, PolicyHolder o2) {
        return o1.getToDate().compareTo(o2.getToDate());
    }
}
