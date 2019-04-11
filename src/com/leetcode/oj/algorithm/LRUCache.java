package com.leetcode.oj.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 *
 * @author shaojie
 * @since 2019/4/2
 */
public class LRUCache {

    private int capacity;

    private Node head;

    private Node tail;

    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        map = new HashMap<>(capacity * 2);
        head = new Node(-1, -1);
        tail = new Node(-2, -2);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        insertHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
        } else {
            node.value = value;
        }
        insertHead(node);
        if (map.size() > capacity) {
            map.remove(tail.prev.key);
            removeTail();
        }
    }

    private void insertHead(Node node) {
        if (node.key == head.next.key) {
            return;
        }
        cleanNode(node);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeTail() {
        if (tail.prev == head) {
            return;
        }
        cleanNode(tail.prev);
    }

    private void cleanNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = null;
        node.prev = null;
    }


    private static class Node {
        int key;
        int value;

        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }


}
