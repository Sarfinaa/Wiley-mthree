package week_5.streams;

import java.util.*;

class Books {
    int id;
    String name;
    String author;
    String publisher;
    int quantity;

    public Books(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Books [author=" + author + ", id=" + id + ", name=" + name + ", publisher=" + publisher + ", quantity="
                + quantity + "]";
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Books other = (Books) obj;
        if (id != other.id)
            return false;
        return true;
    }

}

public class Maps {
    public static void main(String[] args) {
        Books b1 = new Books(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Books b2 = new Books(233, "Operating System", "Galvin", "Wiley", 6);
        Books b3 = new Books(101, "Data Communications & Networking", "Forouzan", "McGraw Hill", 4);
        Books b4 = new Books(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill",
                11);
        Map<Integer, Books> map = new HashMap<>();
        map.put(b1.id, b1);
        map.put(b2.id, b2);
        map.put(b3.id, b3);
        map.put(b4.id, b4);
        map.forEach((k, v) -> {
            System.out.println(v);
        });
        System.out.println("After doubling the quantity!!!");
        map.forEach((k, v) -> {
            v.quantity *= 2;
            map.put(k, v);
            System.out.println(v);
        });

        // if (map.containsKey(233)) {
        // map.get(233).publisher += " USA";
        // map.replace(233, map.get(233));
        // }
        System.out.println("After merging!!");
        map.merge(233, map.get(233), (oldBook, newBook) -> {
            newBook.publisher += " USA";
            return newBook;
        });
        System.out.println(map.get(233));
    }
}
