public class LinkedListDeque<T> {
    public class Node {
        private Node prev;
        private T item;
        private Node next;
        public Node(T i, Node p, Node n) {
            item = i;
            next = n;
            prev = p;
        }

        public Node(Node n, Node p) {
            next = n;
            prev = p;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node first= new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }

    public void addLast(T item) {
        Node last= new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node current = sentinel;
        while (current.next != sentinel) {
            System.out.print(current.next.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T result = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return result;
    }

    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T result = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return result;
    }

    public T get (int index) {
        if (index < 0 ||index >= size) {
            return null;
        }
        Node current = sentinel;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.next.item;
    }


    private T getRecursiveHelper(Node current, int index) {
        if (index == 0) {
            return current.item;
        }else {
            return getRecursiveHelper(current.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        if (index < 0 ||index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);

    }
}
