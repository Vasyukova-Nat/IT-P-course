package lab3;

import java.util.LinkedList; // связный список  будет использоваться для хранения записей в хеш-таблице

public class HashTable<K, V> { // параметры типов K и V, где K — это тип ключа, а V — тип значения
    private static class Entry<K, V> { // внутренний анонимный класс Entry будет использоваться для хранения
                                       // пар ключ-значение в хеш-таблице. Здесь методы для работы с ними
                                       // Угловые скобки потому что это обобщенный класс,
                                       // можем указать тип ключа и тип значения при создании экземпляра
        private K key;
        private V value;

        public Entry(K key, V value) { // Конструктор принимает ключ и значение и присваивает их
                                       // соответствующим полям класса
            this.key = key; // Присваивает полученные аргументы конструктора ключевым полям класса
            this.value = value;
        }

        public K getKey() {
            return key; // возвращает ключ текущего объекта
        }

        public V getValue() {
            return value; // возвращает значение связанное с текущим объектом
        }

        public void setValue(V value) {
            this.value = value; // изменяет значение
        }
    }

    private LinkedList<Entry<K, V>>[] table; // Создаются поля: table — массив связных списков, содержащих пары
                                             // ключ-значение типа Entry, и size — размер хеш-таблицы.
    // private int capacity;
    private int size;

    // public HashTable(int capacity) { // хэш-таблица
    // this.capacity = capacity;
    // table = new LinkedList[capacity];
    // }

    @SuppressWarnings("unchecked") // хэш-таблица
    public HashTable(int capacity) { // Конструктор класса HashTable принимает аргумент capacity, который задает
                                     // начальный размер хеш-таблицы. Внутри конструктора создается массив связных
                                     // списков table нужного размера и size.
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(K key) { // вычисляет индекс в массиве на основе хэш-кода переданного ключа.
        return key.hashCode() % table.length; // Метод hash генерирует хэш-код для ключа и берет остаток от деления на
                                              // длину массива table, чтобы получить индекс для размещения элемента в
                                              // массиве.
    }

    public void put(K key, V value) { // добавляет ключ-значение в хеш-таблицу.
        int index = hash(key); // вычисляется индекс для ключа методом hash
        if (table[index] == null) { // проверяется, существует ли уже связный список для данного индекса. Если нет,
                                    // создается новый связный список.
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) { // цикл по всем элементам связного списка на данном индексе. Если
                                                 // найдена пара ключ-значение, совпадающая с переданной, то значение
                                                 // обновляется и метод завершается.
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value)); // Если записи с данным ключом не существует, добавляем новую запись
                                                   // в связный список.
        size++;
    }

    public V get(K key) { // принимает ключ и возвращает значение, а если его нет - то null
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) { // использует метод hash для вычисления индекса и удаляет первую найденную
                                // пару ключ-значение, совпадающую с переданным ключом
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

    public boolean containsKey(K key) { // проверяет, содержится ли ключ в хеш-таблице. Он вызывает метод get и
                                        // проверяет, вернулось ли значение
        return get(key) != null;
    }

    public int size() {
        return size;
    }
}
