package com.personal.destinationCity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//[["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
//[["B","C"],["D","B"],["C","A"]]
//[["A","Z"]]
public class Solution {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
//        list1.add("London");
//        list1.add("New York");

//        list1.add("B");
//        list1.add("C");

        list1.add("A");
        list1.add("Z");

//        List<String> list2 = new ArrayList<>();
//        list2.add("New York");
//        list2.add("Lima");

//        list2.add("D");
//        list2.add("B");

//        List<String> list3 = new ArrayList<>();
//        list3.add("Lima");
//        list3.add("Sao Paulo");

//        list3.add("C");
//        list3.add("A");

        List<List<String>> paths = new ArrayList<>();
        paths.add(list1);
//        paths.add(list2);
//        paths.add(list3);

        System.out.println(paths);

        Solution solution = new Solution();
        System.out.println(solution.destCity(paths));

    }

    public String destCity(List<List<String>> paths) {

        HashMap<String,String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }

        List<String> values = new ArrayList<>(map.values());

        for (String value : values) {
            if (!map.containsKey(value)) {
                return value;
            }
        }

        return null;
    }
}
