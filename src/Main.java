public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing MyHashTable ===");

        MyHashTable<Integer, String> table=new MyHashTable<>();
        table.put(1, "Apple");
        table.put(2, "Banana");
        table.put(3, "Cherry");

        System.out.println("Get key 2: " + table.get(2));
        System.out.println("Contains value 'Cherry': " + table.contains("Cherry"));
        System.out.println("Get key for value 'Banana': " + table.getKey("Banana"));
        System.out.println("Remove key 1: " + table.remove(1));
        System.out.println("Table size: " + table.size());

        System.out.println("\n=== Testing BST ===");

        BST<Integer, String> bst=new BST<>();
        bst.put(10, "Dog");
        bst.put(5, "Cat");
        bst.put(15, "Monkey");
        bst.put(3, "Bird");
        bst.put(7, "Fish");

        System.out.println("Get key 7: " + bst.get(7)); // Should print Fish
        System.out.println("Contains value 'Dog': " + bst.contains("Dog")); // Should be true
        System.out.println("Get key for value 'Cat': " + bst.getKey("Cat")); // Should be 5
        System.out.println("Remove key 10: " + bst.remove(10)); // Should remove Dog
        System.out.println("BST size: " + bst.size());
    }
}
