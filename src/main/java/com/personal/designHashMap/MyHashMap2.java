package com.personal.designHashMap;

public class MyHashMap2 {

    static final int size = 19997;     // تعداد باکت‌ها (یک عدد اول بزرگ)
    static final int multiplier = 12582917;  // ضریب برای پخش بهتر کلیدها

    //some data inside each there are linked lists
    //what is inside data? null or linked lists
    ListNode[] data; // آرایه ای از لیست ها

    public MyHashMap2() {
        data = new ListNode[size];
    }

    public static void main(String[] args) {
        MyHashMap2 hashMap = new MyHashMap2();
        ListNode[] list = new ListNode[size];
//        System.out.println(Arrays.toString(list));
        System.out.println(hashMap.hashFunction(2));
    }

    //hash function
    //which bucket we should go to?
    private int hashFunction(int key) {
        return (key * multiplier) % size;
    }

    public void put(int key, int value) {
        int bucketIndex = hashFunction(key);

        ListNode node = new ListNode(key, value, data[bucketIndex]);


    }
}
