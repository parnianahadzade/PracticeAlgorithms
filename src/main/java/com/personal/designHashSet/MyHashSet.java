package com.personal.designHashSet;

//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // return True
//myHashSet.contains(3); // return False, (not found)
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // return True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // return False, (already removed)
public class MyHashSet {

    int size = 15013;
    int multiplier = 12345687;

    ListNode[] data;

    public MyHashSet() {
        this.data = new ListNode[size];
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);

        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));

        myHashSet.add(2);

        System.out.println(myHashSet.contains(2));

        myHashSet.remove(2);

        System.out.println(myHashSet.contains(2));
    }

    public int hashFunction(int key) {
        return (int) (((long) key * multiplier) % size);
    }

    public void add(int key) {
        int h = hashFunction(key);
        ListNode currentNode = data[h];

        while (currentNode != null) {
            if (currentNode.key == key) {
                return;
            }
            currentNode = currentNode.next;
        }

        ListNode listNode = new ListNode(key, data[h]);
        data[h] = listNode;
    }

    public void remove(int key) {
        int h = hashFunction(key);
        ListNode currentNode = data[h];
        ListNode previousNode = null;

        while (currentNode != null) {
            if (currentNode.key == key) {
                if (previousNode == null) {
                    data[h] = currentNode.next;
                }
                else {
                    previousNode.next = currentNode.next;
                }
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public boolean contains(int key) {
        int h = hashFunction(key);
        ListNode currentNode = data[h];

        while (currentNode != null) {
            if (currentNode.key == key) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }
}
