public interface MyQueueCommand<E> {
    void add(E value); //добавляет элемент в конец
    void remove(int index); //удаляет элемент под индексом
    void clear(); //очищает коллекцию
    int size(); //возвращает размер коллекции
    E peek(); //возвращает первый элемент в очереди (FIFO)
    E poll(); //возвращает первый элемент в очереди и удаляет его из коллекции
}
