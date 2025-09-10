package com.personal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MaxDepth {
    public static void main(String[] args) {
//        MaxDepth solution1 = new MaxDepth();
//        System.out.println(solution1.maxDepthWithOne("(1+(2*3)+((8)/4))+1"));

//        MaxDepth solution2 = new MaxDepth();
//        System.out.println(solution2.maxDepthWithMore("{ [ ( a + b ) * ( c + d ) ] + ( e * { f + g } ) }"));

        MaxDepth solution3 = new MaxDepth();
        System.out.println(solution3.maxDepthWithMoreEachIndependently("{ [ ( a + b ) * ( c + d ) ] + ( e * { f + g } ) }"));
    }
    public int maxDepthWithOne(String s) {
//        int depth = 0;
//        int maxDepth = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                depth++;
//            }else if (s.charAt(i) == ')') {
//                depth--;
//            }
//
//            if (depth > maxDepth) {
//                maxDepth = depth;
//            }
//        }
//         return maxDepth;

        //solving with stack
        int maxDepth = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            }else if (s.charAt(i) == ')') {
                stack.pop();
            }
            maxDepth = Math.max(maxDepth, stack.size());
        }
        return maxDepth;

    }

    //{ [ ( a + b ) * ( c + d ) ] + ( e * { f + g } ) }
    public int maxDepthWithMore(String s) {
        int maxDepth = 0;
        char maxType = '0';
        Stack<Character> stack = new Stack<Character>();

        Map<Character, Character> pairs = Map.of(
                ')','(',
                '}', '{',
                ']', '['
        );

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                if (stack.size() > maxDepth) {
                    maxDepth = stack.size();
                    maxType = c;
                }
            }
            //containsKey for closing ones - instead of using three if else
            else if (pairs.containsKey(c)) {
                if (pairs.get(c) == stack.peek()) {
                    stack.pop();
                }
            }

//            else if (stack.peek() == '(' && s.charAt(i) == ')') {
//                stack.pop();
//            }
//            else if (stack.peek() == '{' && s.charAt(i) == '}') {
//                stack.pop();
//            }
//            else if (stack.peek() == '[' && s.charAt(i) == ']') {
//                stack.pop();
//            }
        }
        System.out.println(maxType);
        return maxDepth;
    }

    //{ [ ( a + b ) * ( c + d ) ] + ( e * { f + g } ) }
    public List<Integer> maxDepthWithMoreEachIndependently(String s) {
        int maxDepth1 = 0;
        int maxDepth2 = 0;
        int maxDepth3 = 0;

        // (
        int depth1 = 0;
        // {
        int depth2 = 0;
        // [
        int depth3 = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth1++;
                maxDepth1 = Math.max(maxDepth1, depth1);
            } else if (c == ')') {
                depth1--;
            }

            if (c == '{') {
                depth2++;
                maxDepth2 = Math.max(maxDepth2, depth2);
            } else if (c == '}') {
                depth2--;
            }

            if (c == '[') {
                depth3++;
                maxDepth3 = Math.max(maxDepth3, depth3);
            } else if (c == ']') {
                depth3--;
            }
        }

        List<Integer> maxDepthList = new ArrayList<>();
        maxDepthList.add(maxDepth1);
        maxDepthList.add(maxDepth2);
        maxDepthList.add(maxDepth3);

        return maxDepthList;
    }
}

//each open ( --> adds one
//each close ) --> minus one
//1+1-1+1+1-1