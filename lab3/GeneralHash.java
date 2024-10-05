package lab3;

public class GeneralHash {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        System.out.println(hashTable.get("one")); // Вывод: 1
        System.out.println(hashTable.get("two")); // Вывод: 2
        System.out.println(hashTable.get("four")); // Вывод: null

        hashTable.remove("two");
        System.out.println(hashTable.get("two")); // Вывод: null
    }
}
