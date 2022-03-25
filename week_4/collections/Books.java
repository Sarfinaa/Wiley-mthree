package week_4.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Book {
    int id;
    String name;
    String author;
    String publisher;
    int quantity;

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode()) + ((author == null ? 0 : author.hashCode()))
                + id;
        return result;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", id=" + id + ", name=" + name + ", publisher=" + publisher + ", quantity="
                + quantity + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id != other.id)
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}

public class Books {
    public static void main(String[] args) {
        Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
        Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b4 = new Book(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);
        List<Book> library = new ArrayList<>(Arrays.asList(b1, b2, b3, b4));
        Set<Book> set = new HashSet<>();

        for (int i = 0; i < library.size(); i++) {
            for (int j = i + 1; j < library.size(); j++) {
                if (library.get(i).equals(library.get(j))) {
                    set.add(library.get(i));
                }
            }
        }
        System.out.println(String.format("No. of duplicate books = %d", set.size()));
        for (Book book : set) {
            System.out.println(book);
        }
        Book maxQuantity = null;
        int max = Integer.MIN_VALUE;
        for (Book book : library) {
            if (!set.contains(book) && max < book.quantity) {
                maxQuantity = book;
                max = book.quantity;
            }
        }

        System.out.println(maxQuantity);
    }
}