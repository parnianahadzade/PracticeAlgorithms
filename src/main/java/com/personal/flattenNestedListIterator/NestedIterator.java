package com.personal.flattenNestedListIterator;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//Input: nestedList = [[1,1],2,[1,1]]
//Output: [1,1,2,1,1]
//[1,[4,[6]]]

public class NestedIterator implements Iterator<Integer> {

    private final Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() ; i > 0 ; i--) {
            stack.push(nestedList.get(i - 1));
        }
    }

    public static void main(String[] args) {
//        initialize iterator with nestedList
//        res = []
//        while iterator.hasNext()
//        append iterator.next() to the end of res
//        return res

        //initialization
//        List<NestedInteger> leftSide = new ArrayList<>();
//        leftSide.add(new NestedIntegerForIntegerImpl(1));
//        leftSide.add(new NestedIntegerForIntegerImpl(1));
//        NestedInteger left = new NestedIntegerForListImpl(leftSide);
//
//        List<NestedInteger> rightSide = new ArrayList<>();
//        rightSide.add(new NestedIntegerForIntegerImpl(1));
//        rightSide.add(new NestedIntegerForIntegerImpl(1));
//        NestedInteger right = new NestedIntegerForListImpl(rightSide);
//
//        List<NestedInteger> input = new ArrayList<>();
//        input.add(left);
//        input.add(new NestedIntegerForIntegerImpl(2));
//        input.add(right);
//
//        NestedIterator nestedIterator = new NestedIterator(input);


        //[1,[4,[6]]]
        List<NestedInteger> leftSide = new ArrayList<>();
        leftSide.add(new NestedIntegerForIntegerImpl(6));
        NestedInteger left = new NestedIntegerForListImpl(leftSide);

        List<NestedInteger> rightSide = new ArrayList<>();
        rightSide.add(new NestedIntegerForIntegerImpl(4));
        rightSide.add(left);
        NestedInteger right = new NestedIntegerForListImpl(rightSide);

        List<NestedInteger> input = new ArrayList<>();
        input.add(new NestedIntegerForIntegerImpl(1));
        input.add(right);

        NestedIterator nestedIterator = new NestedIterator(input);
        System.out.println(input);

        // Collect the result by calling next() until there are no more elements
        List<Integer> result = new ArrayList<>();
        while (nestedIterator.hasNext()) {
            result.add(nestedIterator.next());
        }

        // Print the result: [1, 1, 2, 1, 1]
        System.out.println(result);
    }


    //Returns the next integer in the nested list.
    @Override
    public Integer next() {

        while (!stack.isEmpty()) {
            if (hasNext()){
                return stack.pop().getInteger();
            }
        }
        return null;
    }

    //Returns true if there are still some integers in the nested list and false otherwise.
    @Override
    public boolean hasNext() {
        //check the stack
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            }

            else {
                List<NestedInteger> nestedIntegerList = stack.pop().getList();
                for (int i = nestedIntegerList.size() ; i > 0 ; i--) {
                    stack.push(nestedIntegerList.get(i - 1));
                }
            }
        }

        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

