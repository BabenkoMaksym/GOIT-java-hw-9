public interface MyLinkedListCommand<E> {
    void add(E value); //добавляет элемент в конец
    void remove(int index); //удаляет элемент под индексом
    void clear(); //очищает коллекцию
    int size(); //возвращает размер коллекции
    MyNode<E> get(int index); //возвращает элемент под индексом
}
