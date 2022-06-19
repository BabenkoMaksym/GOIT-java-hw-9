public class MyStack<E> implements MyStackCommand<E> {
    private int size = 0;
    private MyNode<E> lastElement;
    private MyNode<E> element;

    @Override
    public void push(E value) {
        MyNode newMyNode = new MyNode<E>(value, null);
        if (size == 0) {
            newMyNode.next = null;
        } else {
            newMyNode.next = lastElement;
        }
        this.lastElement = newMyNode;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            element = lastElement;
            if (index == 0 && size == 1) {
                element.item = null;
                lastElement = null;
                element = null;
            } else if (size - index == 1) {
                lastElement.item = null;
                lastElement = lastElement.next;
            } else {
                for (int i = 1; i < size - index -1; i++) {
                    element = element.next;
                }
                MyNode<E> temp = element.next;
                element.next = element.next.next;
                temp.item = null;
                temp.next = null;
            }
            size--;
        }

    }

    @Override
    public void clear() {
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
        return lastElement.item;
    }

    public E pop() {
        MyNode<E> popElement = lastElement;
        lastElement = lastElement.next;
        size--;
        return popElement.item;
    }

}



