public class LinkedListDeque<Item> implements Deque<Item> {
    public class Node {
        private Node prev;
        private Item item;
        private Node next;
        public Node(Item i, Node p, Node n) {
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
        sentinel = new Node(null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(Item item) {
        Node first = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }

    @Override
    public void addLast(Item item) {
        Node last = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node current = sentinel;
        while (current.next != sentinel) {
            System.out.print(current.next.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public Item removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        Item result = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return result;
    }


    public Item removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        Item result = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return result;
    }

    public Item get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = sentinel;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.next.item;
    }


    private Item getRecursiveHelper(Node current, int index) {
        if (index == 0) {
            return current.item;
        } else {
            return getRecursiveHelper(current.next, index - 1);
        }
    }

    public Item getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);

    }
}
