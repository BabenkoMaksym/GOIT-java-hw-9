public class MyLinkedList<E> implements MyLinkedListCommand<E> {
    private int size = 0;
    private MyNode<E> lastElement;
    private MyNode<E> firstElement;

    @Override
    public void add(E value) {
        if (size == 0) {
            MyNode newMyNode = new MyNode<E>(null, value, null);
            newMyNode.next = newMyNode;
            newMyNode.prev = newMyNode;
            this.firstElement = newMyNode;
            this.lastElement = newMyNode;
        } else {
            MyNode newMyNode = new MyNode<E>(lastElement, value, firstElement);
            newMyNode.prev.next = newMyNode;
            this.lastElement = newMyNode;
        }
        size++;
        System.out.println("Елемент добавлен. Размер MyLinkedList = " + size );

    }

    @Override
    public void remove(int index) {
        MyNode element = firstElement;
        if (index > size - 1) {
            System.out.println("Искомого елемента не существует");
        } else {
            if (index == 0) {

            } else {
                for (int i = 0; i < index; i++) {
                    element = element.next;
                }
            }
            element.next.prev = element.prev;
            element.prev.next = element.next;
            element.next = null;
            element.prev = null;
            element.item = null;
            size--;
            System.out.println("Елемент под индексом " + index + " удален. Размер MyLinkedList = " + size);
        }
    }

    @Override
    public void clear() {
        MyNode next;
        MyNode element = firstElement;
        if (size != 0) {
            for (int i = 0; i < size; i++) {
            next = element.next;
            element.prev = null;
            element.next = null;
            element.item = null;
            element = next;
            }
            size = 0;
            System.out.println("MyLinkedList очищен");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public MyNode<E> get(int index) {
        MyNode element = firstElement;
        if (index > size - 1) {
            return null;
        } else if (index == 0) {

        } else {
            for (int i = 0; i < index; i++) {
                element = element.next;
            }
        }
        return element;
    }


}
