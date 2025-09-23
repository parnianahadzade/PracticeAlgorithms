package com.personal.designHashMap;

//MyHashMap1 myHashMap = new MyHashMap1();
//myHashMap.put(1, 1); // The map is now [[1,1]]
//myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
//myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
//myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
//myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
//myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
//myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
//myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
public class MyHashMap2 {

    static final int size = 15013;     // تعداد باکت‌ها (یک عدد اول بزرگ)
    static final int multiplier = 12582917;  // ضریب برای پخش بهتر کلیدها

    //some data inside each there are linked lists
    //what is inside data? null or linked lists
    ListNode[] data; // آرایه ای از لیست ها

    public MyHashMap2() {
        data = new ListNode[size];
    }

    public static void main(String[] args) {
        MyHashMap2 hashMap = new MyHashMap2();
        hashMap.put(1,1);

        hashMap.put(2,2);

        System.out.println(hashMap.get(1));

        System.out.println(hashMap.get(2));

        System.out.println(hashMap.get(3));

        hashMap.put(2,1);

        System.out.println(hashMap.get(2));

        hashMap.remove(2);

        System.out.println(hashMap.get(2));

    }

    //hash function
    //which bucket we should go to?
    private int hashFunction(int key) {
        return (int) (((long) key * multiplier) % size);
    }

    public void put(int key, int value) {
//        remove(key);
//        int index = hashFunction(key);
//        ListNode listNode = new ListNode(key, value, data[index]);
//        data[index] = listNode;

        int index = hashFunction(key);
        ListNode currentNode = data[index];

        while (currentNode != null) {
            if (currentNode.key == key) {
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }

        ListNode listNode = new ListNode(key, value, data[index]);
        data[index] = listNode;

    }

    public int get(int key) {
        int index = hashFunction(key);
        ListNode currentNode = data[index];
        while (currentNode != null){
            if (currentNode.key == key) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return -1;
    }

    //«گره قبلی (prev) دیگه به من (current) اشاره نکنه، بلکه به بعدی من (current.next) اشاره کنه.»
    public void remove(int key) {
        int index = hashFunction(key);
        ListNode currentNode = data[index];
        ListNode prevNode = null;

        while (currentNode != null){

            if (currentNode.key == key) {
                if (prevNode == null) {
                    data[index] = currentNode.next;
                }
                else {
                    prevNode.next = currentNode.next;
                }
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }
}
