public interface MyHashMapCommand<K, V> {
    void put(K key, V value); //добавляет пару ключ + значение

    void remove(K key); //удаляет пару по ключу

    void clear(); //очищает коллекцию

    int size(); //возвращает размер коллекции

    V get(K key); //возвращает значение(Object value) по ключу
}
