public class MyTestingClass {
    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable=new MyHashTable<>();

        System.out.println("добавляем элементы в хэш-таблицу");
        hashTable.put("Женя", 18);
        hashTable.put("Акыл", 19);
        hashTable.put("Жанка", 17);

        System.out.println("размер хэш-таблицы:" + hashTable.size());

        System.out.println("возраст Женя:" + hashTable.get("Женя"));
        System.out.println("возраст Акыл:" + hashTable.get("Акыл"));
        System.out.println("возраст Жанка:" + hashTable.get("Жанка"));

        System.out.println("\nобновляем возраст Женя");
        hashTable.put("Женя", 20);
        System.out.println("обновленный возраст Женя:" + hashTable.get("Женя"));

        System.out.println("\nсодержит ли значение 19? " + hashTable.contains(19));
        System.out.println("содержит ли значение 27? " + hashTable.contains(40));

        System.out.println("\nкто имеет возраст 19? " + hashTable.getKey(19));
        System.out.println("кто имеет возраст 27? " + hashTable.getKey(40));

        System.out.println("\nудаляем Жанка");
        System.out.println("удаленный возраст Жанка:" + hashTable.remove("Жанка"));
        System.out.println("размер хэш-таблицы после удаления:" + hashTable.size());

        System.out.println("содержит ли таблица Жанка? " + hashTable.contains(17));
    }
}