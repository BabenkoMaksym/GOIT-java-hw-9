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
        System.out.println("Елемент добавлен в очередь" + "   " + newMyNode.item);

    }

    @Override
    public void remove(int index) {
        if (index >= size) {
            System.out.println("Елемента под индексом " + index + " не существует");
        } else {
            element = lastElement;
            if (index == 0 && size == 1) {
                System.out.println("11111");
                element.item = null;
                lastElement = null;
                element = null;
            } else if (size - index == 1) {
                System.out.println("22222");
                lastElement.item = null;
                lastElement = lastElement.next;
            } else {
                System.out.println("33333");
                for (int i = 1; i < size - index -1; i++) {
                    element = element.next;
                }
                MyNode<E> temp = element.next;
                element.next = element.next.next;
                temp.item = null;
                temp.next = null;
            }
            size--;
            System.out.println("Елемент под индексом " + index + " был удален из очереди.");
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
    public MyNode<E> peek() {
        return lastElement;
    }

    @Override
    public MyNode<E> pop() {
        MyNode<E> popElement = lastElement;
        lastElement = lastElement.next;
        size--;
        return popElement;
    }

    @Override
    public String toString() {
        MyNode sss;
        StringBuilder sb = new StringBuilder();
        sb.append("MyStack:\n");
        sb.append(lastElement.item);
        sb.append("\n");
        sss = lastElement;
        for (int i = 1; i < size; i++) {
            sss = sss.next;
            sb.append(sss.item);
            sb.append("\n");
        }
        return sb.toString();

    }
}



