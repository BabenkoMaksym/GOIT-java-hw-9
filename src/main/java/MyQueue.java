public class MyQueue<E> implements MyQueueCommand<E> {
    private int size = 0;
    private MyNode<E> firstElement;
    private MyNode<E> lastElement;
    private MyNode<E> element;


    @Override
    public void add(E value) {
        MyNode newMyNode = new MyNode<E>(value, null);
        if (size == 0) {
            newMyNode.next = newMyNode;
            this.firstElement = newMyNode;
        } else {
            lastElement.next = newMyNode;
        }
        this.lastElement = newMyNode;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                firstElement.item = null;
                firstElement = firstElement.next;
            } else {
                MyNode<E> removeElement = null;
                element = firstElement;
                if (index == 1) {
                    removeElement = element.next;
                }else {
                    for (int i = 1; i < index; i++) {
                        element = element.next;
                        removeElement = element.next;
                    }
                }
                element.next = removeElement.next;
                removeElement.next = null;
                removeElement.item = null;
            }
            size--;
        }
    }

    @Override
    public void clear() {
        this.firstElement = null;
        this.lastElement = null;
        this.size = 0;
        this.element = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        return firstElement.item;
    }

    @Override
    public E poll() {
        MyNode<E> pollElement = firstElement;
        firstElement = firstElement.next;
        size--;
        return pollElement.item;
    }


}
