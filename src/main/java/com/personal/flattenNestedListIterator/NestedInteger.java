package com.personal.flattenNestedListIterator;

import java.util.List;

public interface NestedInteger {

    //has single integer not nested list
    boolean isInteger();

    //nested list has integer -> return that integer
    //nested list has another list inside -> return null
    Integer getInteger();

    //return the nested list which the nested integer holds
    //return empty list if it has a single integer
    List<NestedInteger> getList();
}
