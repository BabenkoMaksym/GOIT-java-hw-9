public class MyQueueForMap<K, V> {
    private int size = 0;
    private MyNodeMap<K, V> firstElement;
    private MyNodeMap<K, V> lastElement;
    private MyNodeMap<K, V> element;

    public void add(K key, V value) {
        if (size != 0) {
            if (firstElement.key.equals(key)) {
                firstElement.value = value;
                return;
            } else {
                element = firstElement;
                for (int i = 1; i < size; i++) {
                    element = element.next;
                    if (element.key.equals(key)) {
                        element.value = value;
                        return;
                    }
                }
            }
        }

        MyNodeMap<K, V> myNodeMap = new MyNodeMap<K, V>(key, value, null);
        if (size == 0) {
            myNodeMap.next = myNodeMap;
            this.firstElement = myNodeMap;
        } else {
            lastElement.next = myNodeMap;
        }
        this.lastElement = myNodeMap;
        size++;
        System.out.println("Елемент добавлен в HashMap");
    }

    public void remove(K key) {
        if (size == 0) {
            System.out.println("Елемента с ключем " + key + " не существует");
        } else {
            if (firstElement.key.equals(key)) {
                firstElement.value = null;
                firstElement = firstElement.next;
            } else {
                MyNodeMap<K, V> removeElement = null;
                element = firstElement;
                if (element.next.key.equals(key)) {
                    removeElement = element.next;
                } else {
                    for (int i = 1; i < size; i++) {
                        element = element.next;
                        if (element.next.key.equals(key))
                        removeElement = element.next;
                    }
                }
                element.next = removeElement.next;
                removeElement.next = null;
                removeElement.value = null;
            }
            size--;
            System.out.println("Елемент c ключем " + key + " был удален из HashMap.");
        }
    }

    public void clear() {
        this.firstElement = null;
        this.lastElement = null;
        this.size = 0;
        this.element = null;
    }

    public int size() {
        return size;
    }

    public MyNodeMap<K, V> peek() {
        return firstElement;
    }

    public MyNodeMap<K, V> poll() {
        MyNodeMap<K, V> pollElement = firstElement;
        firstElement = firstElement.next;
        size--;
        return pollElement;
    }

    public MyNodeMap<K, V> get(K key) {
        if (size == 0) {
            System.out.println("Елемента с таким ключем не существует");
        } else {
            if (firstElement.key.equals(key)) {
                return firstElement;
            } else {
                element = firstElement;
                for (int i = 1; i < size; i++) {
                    element = element.next;
                    if (element.key.equals(key)) {
                        return element;
                    }
                }
            }
        }
        return null;
    }
}
