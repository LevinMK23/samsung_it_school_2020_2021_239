import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private Node head, tail, iteratorNode;
    private int size;

    public void addFirst(T value) {
        if (size == 0) {
            head = tail = new Node(value);
        } else {
            head.left = new Node(value);
            head.left.right = head;
            head = head.left;
        }
        size++;
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            head = tail = new Node(value);
        } else {
            tail.right = new Node(value);
            tail.right.left = tail;
            tail = tail.right;
        }
        size++;
    }

    @Override
    public void add(int idx, T value) {
        if (idx == size) {
            add(value);
        } else if (idx == 0) {
            addFirst(value);
        } else {
            Node tmp = head;
            for (int i = 0; i < idx - 1; i++) {
                tmp = tmp.right;
            }
            Node prev = tmp;
            Node next = tmp.right;
            Node current = new Node(value);
            current.right = next;
            current.left = prev;
            prev.right = current;
            next.left = current;
        }
        size++;
    }

    @Override
    public void remove(T value) {
        Node tmp = head;
        while (!tmp.value.equals(value)) {
            tmp = tmp.right;
            if (tmp == null) {
                return;
            }
        }
        Node prev = tmp.left;
        Node next = tmp.right;
        tmp.left = null;
        tmp.right = null;
        prev.right = next;
        next.left = prev;
        size--;
    }

    @Override
    public void remove(int idx) {
        Node tmp = head;
        while (idx > 0) {
            tmp = tmp.right;
            idx--;
            if (tmp == null) {
                return;
            }
        }
        Node prev = tmp.left;
        Node next = tmp.right;
        tmp.left = null;
        tmp.right = null;
        prev.right = next;
        next.left = prev;
        size--;
    }

    @Override
    public T get(int idx) {
        Node tmp = head;
        for (int i = 0; i < idx; i++) {
            tmp = tmp.right;
            if (tmp == null) {
                throw new IllegalArgumentException();
            }
        }
        return tmp.value;
    }

    @Override
    public boolean contains(T value) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.value.equals(value)) {
                return true;
            }
            tmp = tmp.right;
        }
        return false;
    }

    @Override
    public void set(int idx, T value) {
        Node tmp = head;
        for (int i = 0; i < idx; i++) {
            tmp = tmp.right;
            if (tmp == null) {
                throw new IllegalArgumentException();
            }
        }
        tmp.value = value;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder("[");
        for (T value : this) {
            list.append(value).append(", ");
        }
        list.delete(list.length()-2, list.length()).append("]");
        return list.toString();
    }

    @Override
    public Iterator<T> iterator() {
        iteratorNode = head;
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return iteratorNode != null;
            }

            @Override
            public T next() {
                T value = iteratorNode.value;
                iteratorNode = iteratorNode.right;
                return value;
            }
        };
    }

    private class Node {

        private T value;
        private Node left, right;

        public Node(T value) {
            this.value = value;
        }
    }
}
