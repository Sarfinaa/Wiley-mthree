package hashmap;

import java.util.LinkedList;

class MyHashMap {
    LinkedList<Entry>[] map;

    public MyHashMap() {
        map = new LinkedList[769];
    }

    public void put(int key, int value) {
        int hash = key % map.length;
        if (map[hash] == null) {
            map[hash] = new LinkedList<Entry>();
            map[hash].add(new Entry(key, value));
        } else {
            for (Entry entry : map[hash]) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
            map[hash].add(new Entry(key, value));
        }
    }

    public int get(int key) {
        int hash = key & map.length;
        if (map[hash] == null)
            return -1;
        else {
            for (Entry entry : map[hash]) {
                if (entry.key == key)
                    return entry.value;
            }
            return -1;

        }

    }

    public void remove(int key) {
        int hash = key % map.length;
        if (map[hash] == null)
            return;
        Entry rEntry = null;
        for (Entry entry : map[hash]) {
            if (entry.key == key) {
                rEntry = entry;
                break;
            }
        }
        if (rEntry != null) {
            map[hash].remove(rEntry);
        }
    }
}

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class Map {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 2);
        System.out.println(map.get(1));
        map.remove(1);
        System.out.println(map.get(1));

    }
}
