 package Hard;

import java.util.HashMap;

public class LRUCache {


    public class DLL {
        int key,value;
        DLL next, prev;
    }

    HashMap<Integer, DLL> hmap = new HashMap<>();
    DLL head, tail;
    int  curSize, maxSize;

    LRUCache(int size) {
        maxSize =  size;
        head = new DLL();
        tail = new DLL();

        head.next = tail;
        tail.prev = head;

        head.prev = null;
        tail.next = null;
    }

    public int get(int key) {
        DLL node = hmap.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }
    public void put(int key, int val) {
        DLL node = hmap.get(key);
        if (node == null) {
            DLL newNode = new DLL();
            newNode.key = key;
            newNode.value = val;
            hmap.put(key, newNode);
            addNode(newNode);
            curSize++;
            if (curSize > maxSize) {
                removeLRUNode();
            }
        } else {
            node.value = val;
            moveToHead(node);
        }
    }

    public void addNode(DLL node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next  = node;
    }

    public void removeLRUNode() {
        DLL tail = removeTail();
        hmap.remove(tail.key);
        curSize--;
    }

    public DLL removeTail() {
        DLL node = tail.prev;
        removeNode(node);
        return node;
    }

    public void removeNode(DLL node) {
        DLL prevNode = node.prev, nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void moveToHead(DLL node) {
        removeNode(node);
        addNode(node);
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4


    }
}
