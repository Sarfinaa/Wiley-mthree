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
        return key & (map.length - 1);
    }

    public HashMap(int size) {
        map = new Node[size];
    }

    public boolean equals(Node o1, Node o2) {

        if (o1.hash == o2.hash && o1.key == o2.key)
            return true;
        return false;
    }

    public void put(int key, int value) {
        int hash = calHash(key);
        Node nNode = new Node(key, value, hash);
        Node tmp = map[hash];
        Node prev = null;
        boolean found = false;
        if (tmp != null) {
            while (tmp != null) {
                if (nodeFound(hash, key, tmp)) {
                    tmp.value = value;
                    found = true;
                    break;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            if (!found) {
                prev.next = nNode;
            }
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

    public int size() {
        return size;
    }

    public boolean containsKey(int key) {
        int hash = calHash(key);
        Node tmp = map[hash];
        if (tmp == null) {
            return false;
        } else {
            while (tmp != null) {
                if (nodeFound(hash, key, tmp)) {
                    return true;
                }
                tmp = tmp.next;
            }
            return false;
        }
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
        map.put(5, 6);
        map.put(6, 2);
        map.put(6, 3);
        map.put(2, 3);
        System.out.println(map);

    }
}
