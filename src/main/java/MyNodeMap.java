public class MyNodeMap<K,V> {

    K key;
    V value;
    MyNodeMap<K,V> next;
    MyNodeMap<K,V> prev;

    public MyNodeMap() {
        this.key = null;
        this.value = null;
        this.next = null;
        this.prev = null;
    }

    public MyNodeMap(K key, V value, MyNodeMap<K, V> next, MyNodeMap<K, V> prev) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public MyNodeMap(K key, V value, MyNodeMap<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyNodeMap{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
