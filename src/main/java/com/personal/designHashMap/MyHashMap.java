package com.personal.designHashMap;

import java.util.ArrayList;
import java.util.Iterator;

//MyHashMap1 myHashMap = new MyHashMap1();
//myHashMap.put(1, 1); // The map is now [[1,1]]
//myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
//myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
//myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
//myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
//myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
//myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
//myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
public class MyHashMap {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,1);
        myHashMap.put(2,2);

        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));

        myHashMap.put(2,1);

        System.out.println(myHashMap.get(2));

        myHashMap.remove(2);

        System.out.println(myHashMap.get(2));



    }

    private final ArrayList<ArrayList<Integer>> map;

    public MyHashMap() {
        map = new ArrayList<>();
    }

    public void put(int key, int value) {

        for (ArrayList<Integer> arrayList1 : map) {
            if (arrayList1.get(0) == key) {
                arrayList1.set(1, value);
                System.out.println(map);
                return;
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(key);
        arrayList.add(value);
        map.add(arrayList);


        System.out.println(map);
    }

    public int get(int key) {

        for (ArrayList<Integer> arrayList1 : map) {
            if (arrayList1.get(0) == key) {
                return arrayList1.get(1);
            }
        }

        return -1;
    }

    public void remove(int key) {
        Iterator<ArrayList<Integer>> iterator = map.iterator();

        while (iterator.hasNext()) {
          ArrayList<Integer> arrayList = iterator.next();
          if (arrayList.get(0) == key) {
              iterator.remove();
          }
        }

        System.out.println(map);
    }
}

/**
 * Your MyHashMap1 object will be instantiated and called as such:
 * MyHashMap1 obj = new MyHashMap1();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
