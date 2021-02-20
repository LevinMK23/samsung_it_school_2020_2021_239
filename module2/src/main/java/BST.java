import java.util.function.Consumer;

public class BST<T extends Comparable<T>> {

    private class Node {
        T value;
        Node left, right, parent;
        int count;

        public Node(T value) {
            this.value = value;
            count = 1;
        }
    }

    private Node root;
    private int size;

    private void add(Node node, T value) {
        node.count++;
        if (value.compareTo(node.value) > 0) {
            if (node.right == null) {
                node.right = new Node(value);
                size++;
            } else {
                add(node.right, value);
            }
        } else if (value.compareTo(node.value) < 0) {
            if (node.left == null) {
                node.left = new Node(value);
                size++;
            } else {
                add(node.left, value);
            }
        }
    }

    private T getKOrder(Node node, int order) {
        int need;
        if (node != null && node.left != null) {
            need = node.left.count + 1;
        } else {
            need = 1;
        }
        if (order == need) {
            return node.value;
        } else {
            if (order < need) {
                return getKOrder(node.left, order);
            } else {
                return getKOrder(node.right, order - need);
            }
        }
    }

    public T getKOrder(int order) {
        return getKOrder(root, order);
    }

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            size++;
        } else {
            add(root, value);
        }
    }

    private boolean contains(Node node, T value) {
        if (node == null) {
            return false;
        }
        if (value.compareTo(node.value) == 0) {
            return true;
        } else if (value.compareTo(node.value) > 0) {
            return contains(node.right, value);
        } else {
            return contains(node.left, value);
        }
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    public void remove(T value) {

    }

    private void go(Node node, Consumer<T> consumer, String prefix) {
        if (node == null) {
            return;
        }
        go(node.left, consumer, prefix + "-");
        System.out.printf("%s(%s:%s)\n", prefix, node.value, node.count);
        go(node.right, consumer, prefix + "-");
    }

    public void forEach(Consumer<T> consumer) {
        go(root, consumer, "");
    }

    public int getSize() {
        return size;
    }
}
