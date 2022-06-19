public class MyHashMap<K, V> implements MyHashMapCommand<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private int userCapacity;
    private MyQueueForMap<K, V>[] myHashMap;

    public MyHashMap() {
        myHashMap = new MyQueueForMap[DEFAULT_CAPACITY];
        this.userCapacity = DEFAULT_CAPACITY;
    }

    public MyHashMap(int userCapacity) {
        this.userCapacity = userCapacity;
        myHashMap = new MyQueueForMap[userCapacity];
    }

    public MyHashMap(int userCapacity, float userFullness) {
        this.userCapacity = userCapacity;
        myHashMap = new MyQueueForMap[userCapacity];
    }

    @Override
    public void put(K key, V value) {
        if (myHashMap[index(key)] == null) {
            myHashMap[index(key)] = new MyQueueForMap<K, V>();
        }
        myHashMap[index(key)].add(key, value);
    }

    @Override
    public void remove(K key) {
        if (myHashMap[index(key)] != null) {
            myHashMap[index(key)].remove(key);
        }
    }

    @Override
    public void clear() {
        myHashMap = new MyQueueForMap[userCapacity];
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < userCapacity - 1; i++) {
            if (myHashMap[i] != null) {
                size += myHashMap[i].size();
            }
        }
        return size;
    }

    @Override
    public V get(K key) {
        if (myHashMap[index(key)] != null && myHashMap[index(key)].size() != 0) {
            return (V) myHashMap[index(key)].get(key).value;
        }
        return null;
    }

    private int index(K key) {
        return key.hashCode() % userCapacity;
    }
}
