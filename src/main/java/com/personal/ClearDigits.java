package com.personal;

import java.util.Stack;

public class ClearDigits {
    public static void main(String[] args) {
        ClearDigits c = new ClearDigits();
        System.out.println(c.clearDigits("abc"));
        System.out.println(c.clearDigits("cb34"));
    }

    public String clearDigits(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)){
                if (!stack.isEmpty()){
                    stack.pop();
                }

            }else if (!Character.isDigit(c)){
                stack.push(c);
            }
        }

        //why string builder is better?
//        result += c in a loop → copy the whole thing every time → about O(n²) work.
//        StringBuilder.append(c) → just add the next letter (rare resize) → O(n) total.

//        String result = "";
//        for (int i = 0; i < stack.size(); i++) {
//            char c = stack.get(i);
//            result += c;
//        }
//        return result;

        StringBuilder result = new StringBuilder();
        for (Character c : stack) {
            result.append(c);
        }
        return "\"" + result.toString() + "\"";
    }
}
