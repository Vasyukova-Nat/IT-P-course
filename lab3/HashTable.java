package lab3;

import java.util.LinkedList;

public class HashTable<K, V> {
    private static class Entry<K, V> { // пара ключ-значение. Этот класс содержит методы для работы с ними
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int capacity;

    public HashTable(int capacity) { // хэш-таблица
        this.capacity = capacity;
        table = new LinkedList[capacity];
    }

    private int hash(K key) { // вычисляет индекс в массиве на основе хэш-кода переданного ключа.
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null; // ключ не найден
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    return;
                }
            }
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

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
