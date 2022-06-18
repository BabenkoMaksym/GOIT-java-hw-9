public class MyNode<E> {
    E item;
    MyNode<E> next;
    MyNode<E> prev;

    public MyNode(MyNode<E> prev, E item, MyNode<E> next) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    public MyNode(E item, MyNode<E> next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "item=" + item +
                '}';
    }
}
