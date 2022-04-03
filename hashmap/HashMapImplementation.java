package hashmap;

import java.util.Arrays;

class Node {
    int key;
    int value;
    int hash;
    Node next;

    public Node(int key, int value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = null;
    }

    @Override
    public String toString() {
        String result = "[" + key + "=" + value + "]";
        Node tmp = next;
        while (tmp != null) {
            result += "," + "[" + tmp.key + "=" + tmp.value + "]";
            tmp = tmp.next;
        }
        return result;
    }

}

class HashMap {
    Node[] map;
    int size = 0;

    public int calHash(int key) {
        return key % map.length;
    }

    public static Node getLastNode(Node head) {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public HashMap(int size) {
        map = new Node[size];
    }

    public void put(int key, int value) {
        int hash = calHash(key);
        Node nNode = new Node(key, value, hash);
        if (map[hash] != null) {
            Node fNode = map[hash];
            Node getLast = getLastNode(fNode);
            getLast.next = nNode;

        } else {
            map[hash] = nNode;
        }
        size++;
    }

    public boolean nodeFound(int hash, int key, Node node) {
        return (node.hash == hash && node.key == key);

    }

    public int get(int key) {
        int hash = calHash(key);
        Node node = map[hash];
        int value = -1;
        if (nodeFound(hash, key, node)) {
            value = node.value;
        } else if (node.next != null) {
            Node tmp = node;
            while (tmp != null) {
                if (nodeFound(hash, key, tmp)) {
                    value = tmp.value;
                    break;
                }
                tmp = tmp.next;
            }
        }
        return value;
    }

    @Override
    public String toString() {
        String res = "[";
        for (int i = 0; i < map.length; i++) {
            if (map[i] != null)
                res += map[i] + "";
        }
        res += "]";
        return res;
    }

}

public class HashMapImplementation {
    public static void main(String[] args) {
        HashMap map = new HashMap(4);
        map.put(1, 2);
        map.put(5, 3);
        map.put(2, 4);
        System.out.println(map);

    }
}
