package com.datastructures.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // to store the key value pairs we are using HashMap
    // to store the least recently used we will use doubly limnked list

    //node of DLL
    public class Node
    {
        int key;
        int value;
        Node prev;
        Node next;
    }

    Map<Integer, Node> cache;
    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {

        cache = new HashMap<>();
        cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node)
    {
        Node nextToNext = head.next;
        node.next = nextToNext;
        node.prev = head;

        nextToNext.prev = node;
        head.next = node;
    }

    public void removeNode(Node node)
    {
        Node prv = node.prev;
        Node nxt = node.next;

        prv.next = nxt;
        nxt.prev = prv;

        node.prev = node.next = null;
    }

    public void moveToFront(Node node)
    {
        removeNode(node);
        addNode(node);
    }

    public int get(int key) {

        Node node = cache.get(key);

        if(node==null)
        {
            return -1;
        }
        else{
            int res = node.value;
            moveToFront(node);
            return res;
        }

    }

    public void set(int key, int value) {

        Node node = cache.get(key);

        if(node == null)
        {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            if(cache.size() == cap)
            {
                Node lru = tail.prev;
                cache.remove(lru.key);
                removeNode(lru);
            }
            cache.put(key, newNode);
            addNode(newNode);
        }
        else
        {
            node.value = value;
            moveToFront(node);
        }

    }
}

