import java.util.Iterator;

/**
 * Класс GBLinkedList представляет собой реализацию интерфейса GBList для связного списка.
 * Он содержит методы для добавления, удаления и обновления элементов списка, а также для получения размера списка.
 * <p>
 * Класс имеет приватные поля head и tail для хранения ссылок на первый и последний узлы списка соответственно,
 * а также приватное поле size для хранения текущего размера списка.
 * <p>
 * Методы класса GBLinkedList:
 * - add(Type t) - добавляет элемент в начало списка. Возвращает true, если элемент успешно добавлен, иначе false.
 * - addEnd(Type t) - добавляет элемент в конец списка. Возвращает true, если элемент успешно добавлен, иначе false.
 * - remove(int index) - удаляет элемент с указанным индексом из списка. Если индекс выходит за пределы списка, выбрасывается StackOverflowError.
 * - get(int index) - возвращает элемент с указанным индексом из списка. Если индекс выходит за пределы списка, выбрасывается StackOverflowError.
 * - size() - возвращает текущий размер списка.
 * - update(int index, Type t) - обновляет элемент с указанным индексом в списке. Если индекс выходит за пределы списка, выбрасывается StackOverflowError.
 * <p>
 * Имеется также приватный вспомогательный метод overflowCheck(int index), который проверяет, находится ли индекс в пределах списка.
 * <p>
 * Класс GBLinkedList реализует интерфейс GBList и имеет типизацию для элементов списка. Он может быть использован для создания и управления
 * связным списком любого типа данных.
 *
 * @param <Type> тип элемента списка
 */
public class GBLinkedList<Type> implements GBList<Type> {
    private Node<Type> head;
    private Node<Type> tail;
    private int size;

    public GBLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Добавляет элемент в начало списка.
     *
     * @param t элемент для добавления
     * @return true, если элемент успешно добавлен, иначе false
     */
    @Override
    public boolean add(Type t) {
        try {
            Node<Type> newNode = new Node<Type>(t);
            if (head != null) {
                newNode.next = head;
                head.previous = newNode;
            } else tail = newNode;
            head = newNode;
            size += 1;
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param t элемент для добавления
     * @return true, если элемент успешно добавлен, иначе false
     */
    @Override
    public boolean addEnd(Type t) {
        try {
            Node<Type> newNode = new Node<Type>(t);
            if (head == null) {
                head = newNode;
            } else {
                newNode.previous = tail;
                tail.next = newNode;
            }
            tail = newNode;
            size += 1;
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Удаляет элемент с указанным индексом из списка.
     *
     * @param index индекс элемента для удаления
     * @throws StackOverflowError если индекс выходит за пределы списка
     */
    @Override
    public void remove(int index) {
        if (overflowCheck(index)) {
            if (size > 1) {
                Node<Type> temp = head;
                for (int i = 0; i < size; i++) {
                    if (i == index) {
                        if (temp.next == null) {
                            tail = temp.previous;
                            tail.next = null;
                        } else if (temp.previous == null) {
                            head = temp.next;
                            head.previous = null;
                        } else {
                            temp.previous.next = temp.next;
                            temp.next.previous = temp.previous;
                        }
                        size--;
                        return;
                    }
                    temp = temp.next;
                }
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            }
        } else
            throw new StackOverflowError(); //Так как пока что не имею представления как описывать собственные ошибки, решил, что этот вариант больше всего подходит данному методу.

    }

    /**
     * Возвращает элемент с указанным индексом из списка.
     *
     * @param index индекс элемента
     * @return элемент с указанным индексом
     * @throws StackOverflowError если индекс выходит за пределы списка
     */
    @Override
    public Type get(int index) {
        if (overflowCheck(index)) {
            Node<Type> temp = head;
            for (int i = 0; i < size; i++) {
                if (i == index) return temp.getValue();
                temp = temp.next;
            }
        }
        throw new StackOverflowError(); //Так как пока что не имею представления как описывать собственные ошибки, решил, что этот вариант больше всего подходит данному методу.
    }

    /**
     * Возвращает текущий размер списка.
     *
     * @return размер списка
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Обновляет элемент с указанным индексом в списке.
     *
     * @param index индекс элемента для обновления
     * @param t     новое значение для элемента
     * @throws StackOverflowError если индекс выходит за пределы списка
     */
    @Override
    public void update(int index, Type t) {
        Node<Type> newNode = new Node<>(t);
        if (overflowCheck(index)) {
            Node<Type> temp = head;
            if (size == 1) {
                tail = head = newNode;
            } else {
                for (int i = 0; i < size; i++) {
                    if (i == index) {
                        newNode.next = temp.next;
                        newNode.previous = temp.previous;
                        if (temp.previous != null) temp.previous.next = newNode;
                        if (temp.next != null) temp.next.previous = newNode;
                        return;
                    }
                    temp = temp.next;
                }
            }

        } else
            throw new StackOverflowError(); //Так как пока что не имею представления как описывать собственные ошибки, решил, что этот вариант больше всего подходит данному методу.
    }

    @Override
    public Iterator<Type> iterator() {
        return new ArrayIterator<Type>((Type[]) toArray());
    }

    /**
     * Преобразует список в массив типа Node<Type>[].
     *
     * @return массив элементов списка
     */
    @SuppressWarnings("unchecked")
    private Node<Type>[] toArray() {
        Node<Type>[] nodes = (Node<Type>[]) new Object[size];
        Node<Type> temp = head;
        for (int i = 0; i < size; i++) {
            nodes[i] = temp;
            temp = temp.next;
        }
        return nodes;
    }

    /**
     * Проверяет, находится ли индекс в пределах списка.
     *
     * @param index индекс для проверки
     * @return true, если индекс находится в пределах списка, иначе false
     */
    private boolean overflowCheck(int index) {
        return (index < size && index >= 0);
    }

    @Override
    public String toString() {
        String result = "";
        if (size > 0) {
            Node<Type> temp = head;
            for (int i = 0; i < size - 1; i++) {
                result += temp.toString() + ", ";
                temp = temp.next;
            }
            result += tail.toString();
        }
        return "[" + result + "]";
    }

}
