package Easy;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    class HashNode {
        int key;
        int val;
        HashNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    List<HashNode> nodes ;
    int size;
    public MyHashMap() {
        nodes = new ArrayList<HashNode>();
        size = 1000;
    }
    void put(int key, int value) {
        int hashKey = hash(key);
        HashNode node = new HashNode(hashKey, value);
        for (int i=0;i<nodes.size();i++) {
            HashNode n1 = nodes.get(i);
            if (n1.key == (hashKey)){
                nodes.remove(i);
                break;
            }
        }

        nodes.add(node);
    }

    int get(int key) {
        int hashKey = hash(key);
        for (int i=0;i<nodes.size();i++) {
            if (hashKey == nodes.get(i).key) return nodes.get(i).val;
        }
        return -1;
    }

//    void remove(int key) {
//
//        nodes.remove(hash(key));
//
//    }

//    int size;
//    List<HashNode>[] hmap ;
//
//    public MyHashMap() {
//      this.size = 1000;
//      this.hmap = new ArrayList[size];
//        for (int i = 0; i < size; i++) hmap[i] = new ArrayList<>();
//    }
//
//    public void put(int key, int val) {
//        HashNode node = get(hash(key), key);
//        if (node != null) {
//            node.val = val;
//        } else {
//            hmap[hash(key)].add(new HashNode(key, val));
//
//        }
//    }
//
//
//    HashNode get(int hash, int key) {
//        List<HashNode> nodes = hmap[hash];
//        for(HashNode node: nodes) {
//            if (node.key == key) {
//                return node;
//            }
//        }
//
//        return null;
//    }
//    public int get(int key) {
//        HashNode node = get(hash(key), key);
//        if (node == null)
//            return -1;
//        else
//            return node.val;
//    }
//
//    void remove(int key) {
//        HashNode node = get(hash(key), key);
//        if (node == null) return;
//        hmap[hash(key)].remove(node);
//    }

    int hash(int key) {
        return key % size;
    }
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.get(2);            // returns 1
//        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);
    }
}
