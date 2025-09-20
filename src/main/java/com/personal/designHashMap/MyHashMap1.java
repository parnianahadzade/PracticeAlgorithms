package com.personal.designHashMap;

import java.util.Arrays;

//MyHashMap1 myHashMap = new MyHashMap1();
//myHashMap.put(1, 1); // The map is now [[1,1]]
//myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
//myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
//myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
//myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
//myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
//myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
//myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
public class MyHashMap1 {

    public static void main(String[] args) {
        MyHashMap1 myHashMap1 = new MyHashMap1();
        myHashMap1.put(1,1);
        myHashMap1.put(2,2);

        System.out.println(myHashMap1.get(1));
        System.out.println(myHashMap1.get(3));

        myHashMap1.put(2,1);

        System.out.println(myHashMap1.get(2));

        myHashMap1.remove(2);

        System.out.println(myHashMap1.get(2));

    }


    int[] data;

    public MyHashMap1() {
        data = new int[1000001];
        Arrays.fill(data, -1);
    }

    public void put(int key, int value) {
        data[key] = value;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = -1;
    }
}

/**
 * Your MyHashMap1 object will be instantiated and called as such:
 * MyHashMap1 obj = new MyHashMap1();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

