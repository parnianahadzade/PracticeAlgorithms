package com.personal;

public class ReversePrefixOfWord {
    public static void main(String[] args) {
        ReversePrefixOfWord reversePrefixOfWord = new ReversePrefixOfWord();
        System.out.println(reversePrefixOfWord.reversePrefix("abcdefd", 'd'));
        System.out.println(reversePrefixOfWord.reversePrefix("xyxzxe", 'z'));
    }

    //Input: word = "abcdefd", ch = "d"
    public String reversePrefix(String word, char ch) {

//        int indexOfCh = word.indexOf(ch);
//        if (indexOfCh == -1) {
//            return word;
//        }
//
//        String prefix = word.substring(0, indexOfCh+1);
//        String suffix = word.substring(indexOfCh+1);
//
//        //using string builder to reverse
//        StringBuilder reversed  = new StringBuilder(prefix).reverse();
//        String newWord = reversed + suffix;
//
//        return newWord;


        //solving without string builder
        int indexOfCh = word.indexOf(ch);
        if (indexOfCh == -1) {
            return word;
        }

        String prefix = word.substring(0, indexOfCh+1);
        String suffix = word.substring(indexOfCh+1);

        char[] chars = prefix.toCharArray();

        int i = 0, j = indexOfCh;
        while (i < j) {
            // Swap characters
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        String newWord = new String(chars) + suffix;

        return newWord;
    }
}
