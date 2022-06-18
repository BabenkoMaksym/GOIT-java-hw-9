public class MyHashMap<K, V> implements MyHashMapCommand<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_FULLNESS = 0.75f;
    private int userCapacity;
    private float userFullness;
    private MyQueueForMap<K, V>[] myHashMap;

    public MyHashMap() {
        myHashMap = new MyQueueForMap[DEFAULT_CAPACITY];
        this.userCapacity = DEFAULT_CAPACITY;
        this.userFullness = DEFAULT_FULLNESS;
    }

    public MyHashMap(int userCapacity) {
        this.userCapacity = userCapacity;
        myHashMap = new MyQueueForMap[userCapacity];
        this.userFullness = DEFAULT_FULLNESS;
    }

    public MyHashMap(int userCapacity, float userFullness) {
        this.userCapacity = userCapacity;
        this.userFullness = userFullness;
        myHashMap = new MyQueueForMap[userCapacity];
    }

    @Override
    public void put(K key, V value) {
        int index = key.hashCode() % userCapacity;
        myHashMap[index].add(key, value);
    }

    @Override
    public void remove(K key) {
        myHashMap[index(key)].remove(key);
    }

    @Override
    public void clear() {
        myHashMap = new MyQueueForMap[userCapacity];
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < userCapacity - 1; i++) {
            size += myHashMap[i].size();
        }
        return size;
    }

    @Override
    public V get(K key) {
        return (V) myHashMap[index(key)].get(key).value;
    }

    private int index(K key) {
        return key.hashCode() % userCapacity;
    }
}
