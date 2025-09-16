package com.personal.flattenNestedListIterator;

import java.util.Collections;
import java.util.List;

public class NestedIntegerForIntegerImpl implements NestedInteger{

    private final Integer value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public NestedIntegerForIntegerImpl(Integer value) {
        this.value = value;
    }

    //has single integer not nested list
    //this is true cause we want integers
    @Override
    public boolean isInteger() {
        return true;
    }

    //nested list has integer -> return that integer
    //nested list has another list inside -> return null
    @Override
    public Integer getInteger() {
        return value;
    }

    //return the nested list which the nested integer holds
    //return empty list if it has a single integer
    @Override
    public List<NestedInteger> getList() {
        return Collections.emptyList();
    }
}
