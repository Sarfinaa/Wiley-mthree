package week_5.streams;

import java.util.*;
import java.util.stream.Collectors;

class Bookss implements Comparable<Bookss> {
    int id;
    String name;
    String author;
    String publisher;
    int quantity;

    public int compareTo(Bookss other) {
        return this.id - other.id;
    }

    public Bookss(int id, String name, String author, String publisher, int quantity) {
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
        Bookss other = (Bookss) obj;
        if (id != other.id)
            return false;
        return true;
    }

}

public class StreamTask {
    public static void main(String[] args) {
        Bookss b1 = new Bookss(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Bookss b2 = new Bookss(233, "Operating System", "Galvin", "Wiley", 6);
        Bookss b3 = new Bookss(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Bookss b4 = new Bookss(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);
        List<Bookss> list = new ArrayList<>(Arrays.asList(b1, b2, b3, b4));
        list.forEach(System.out::println);
        System.out.println("Set");
        list.stream().collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("Sorted List");
        list.stream().sorted().toList().forEach(System.out::println);
        System.out.println("Double val list");
        list.stream().map(book -> {
            book.quantity *= 2;
            return book;
        }).toList().forEach(System.out::println);
        System.out.println("Filtered List");
        list.stream().filter(book -> book.quantity > 10).toList().forEach(System.out::println);
        System.out.println("Reduced List");
        int reduced = list.stream().filter(book -> book.id < 200).map(book -> book.quantity).reduce(0, (ac, val) -> {
            return val + ac;
        });
        System.out.println(reduced);
    }
}
