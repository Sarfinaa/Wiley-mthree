package week_4.collections;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<Character>();
        list.add('a');
        list.add('A');
        list.add('5');
        list.add('Z');
        Set<Integer> set = new HashSet<Integer>();
        for (char c : list)
            set.add((int) c);
        System.out.println(set);
        TreeSet<Integer> treeSet = new TreeSet<Integer>(set);
        System.out.println(treeSet.descendingSet());
    }
}
