public class BST<K extends Comparable<K>, V> {
    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "{" + key + ": " + value + "}";
        }
    }

    private Node<K, V> root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public void put(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value);
            size++;
            return;
        }

        Node<K, V> current = root;

        while (true) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                if (current.left == null) {
                    current.left = new Node<>(key, value);
                    size++;
                    return;
                }
                current = current.left;
            } else if (cmp > 0) {
                if (current.right == null) {
                    current.right = new Node<>(key, value);
                    size++;
                    return;
                }
                current = current.right;
            } else {
                current.value = value;
                return;
            }
        }
    }

    public V get(K key) {
        Node<K, V> current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.value;
            }
        }

        return null;
    }

    public boolean contains(V value) {
        if (root == null) {
            return false;
        }

        Node<K, V> current = root;
        java.util.Stack<Node<K, V>> stack = new java.util.Stack<>();

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (current.value.equals(value)) {
                return true;
            }
            current = current.right;
        }
        return false;
    }

    public K getKey(V value) {
        if (root == null) {
            return null;
        }

        Node<K, V> current = root;
        java.util.Stack<Node<K, V>> stack = new java.util.Stack<>();

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (current.value.equals(value)) {
                return current.key;
            }
            current = current.right;
        }
        return null;
    }

    public V remove(K key) {
        Node<K, V> parent = null;
        Node<K, V> current = root;

        while (current != null && !current.key.equals(key)) {
            parent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return null; // Key not found
        }

        size--;

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        else if (current.left == null || current.right == null) {
            Node<K, V> child = (current.left != null) ? current.left : current.right;

            if (current == root) {
                root = child;
            } else if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        else {
            Node<K, V> successorParent = current;
            Node<K, V> successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.key = successor.key;
            current.value = successor.value;

            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }

        return current.value;
    }

    public int size() {
        return size;
    }
}
