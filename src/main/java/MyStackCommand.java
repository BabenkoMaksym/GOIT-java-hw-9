public interface MyStackCommand<E> {
    void push(E value); //добавляет элемент в конец
    void remove(int index); //удаляет элемент под индексом
    void clear(); //очищает коллекцию
    int size(); //возвращает размер коллекции
    E peek(); //возвращает первый элемент в стеке (LIFO)
    E pop(); //возвращает первый элемент в стеке и удаляет его из коллекции
}
