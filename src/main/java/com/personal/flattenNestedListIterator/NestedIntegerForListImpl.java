package com.personal.flattenNestedListIterator;

import java.util.List;

public class NestedIntegerForListImpl implements NestedInteger{

    private final List<NestedInteger> nestedList;

    @Override
    public String toString() {
        return nestedList.toString();
    }

    public NestedIntegerForListImpl(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    //has single integer not nested list
    //this is false cause we want lists here
    @Override
    public boolean isInteger() {
        return false;
    }

    //nested list has integer -> return that integer
    //nested list has another list inside -> return null
    @Override
    public Integer getInteger() {
        return null;
    }

    //return the nested list which the nested integer holds
    //return empty list if it has a single integer
    @Override
    public List<NestedInteger> getList() {
        return nestedList;
    }
}
