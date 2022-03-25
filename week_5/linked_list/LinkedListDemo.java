package week_5.linked_list;

class LinkedList {
    Node head;
    int size = 0;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    void display() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    void addLast(int data) {
        Node nnode = new Node(data);
        if (size == 0) {
            head = nnode;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = nnode;
        }
        size++;
    }

    boolean contains(int data) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.data == data)
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    Node getNodeAt(int position) {
        int idx = position - 1;
        if (size == 0 || idx < 0 || idx >= size) {
            throw new IllegalArgumentException("Invalid position!!! ");
        }
        Node tmp = head;
        int count = 0;
        while (count++ < idx) {
            tmp = tmp.next;
        }
        return tmp;
    }

    void replace(int position, int data) {
        getNodeAt(position).data = data;
    }

    int removeFirst() {
        int el = head.data;
        head = head.next;
        size--;
        return el;

    }

    int removeLast() {
        Node tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        int el = tmp.next.data;
        tmp.next = null;
        size--;
        return el;
    }

    int removeAt(int position) {
        int idx = position - 1;
        if (size == 0 || idx > size || head == null) {
            throw new IllegalArgumentException("No element is present");
        } else if (idx == 0) {
            return removeFirst();
        } else if (idx == size) {
            return removeLast();
        } else {
            // 1 2 3 4
            int count = 0;
            Node tmp = head;
            while (++count < idx) {
                tmp = tmp.next;
            }
            int el = tmp.next.data;
            tmp.next = tmp.next.next;
            size--;
            return el;
        }

    }

    void addAtIndex(int position, int data) {
        int idx = position - 1;
        if (idx > size || idx < 0 || size == 0) {
            throw new IllegalArgumentException("Enter Correct Index for Insertion !!!");
        } else if (idx == 0) {
            addFirst(data);
        } else if (idx == size) {
            addLast(data);
        } else {
            // 1 2 3 4
            Node nnode = new Node(data);
            Node tmp = head;
            int count = 0;
            while (++count < idx) {
                tmp = tmp.next;
            }
            nnode.next = tmp.next;
            tmp.next = nnode;
            size++;
        }
    }

    void addFirst(int data) {
        if (size == 0) {
            head = new Node(data);
        } else {
            Node nnode = new Node(data);
            nnode.next = head;
            head = nnode;
        }
        size++;
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(4);
        list.addAtIndex(3, 3);
        list.removeAt(4);
        list.replace(3, 2);
        list.display();
        // System.out.println(list.getNodeAt());
        System.out.println(list.contains(3));
    }
}
