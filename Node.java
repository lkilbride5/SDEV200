import java.util.NoSuchElementException;
import java.util.ListIterator;

public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0;

    public TwoWayLinkedList() {
    }

    public TwoWayLinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        newNode.previous = null;

        if (size == 0) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }

        head = newNode;
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = null;
        newNode.previous = tail;

        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node<E> newNode = new Node<>(e);
            Node<E> current = getNodeAt(index);
            Node<E> previousNode = current.previous;

            newNode.previous = previousNode;
            newNode.next = current;

            previousNode.next = newNode;
            current.previous = newNode;

            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        E removedElement = head.element;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        } else {
            head.previous = null;
        }

        return removedElement;
    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        E removedElement = tail.element;
        tail = tail.previous;
        size--;

        if (size == 0) {
            head = null;
        } else {
            tail.next = null;
        }

        return removedElement;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> current = getNodeAt(index);
            Node<E> previousNode = current.previous;
            Node<E> nextNode = current.next;

            previousNode.next = nextNode;
            nextNode.previous = previousNode;

            size--;

            return current.element;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    public void clear() {
        size = 0;
        head = tail = null;
    }

    public boolean contains(Object e) {
        Node<E> current = head;

        while (current != null) {
            if (e.equals(current.element)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return getNodeAt(index).element;
    }

    public int indexOf(Object e) {
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            if (e.equals(current.element)) {
                return i;
            }
            current = current.next;
        }

        return -1;
    }

    public int lastIndexOf(E e) {
        Node<E> current = tail;

        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(current.element)) {
                return i;
            }
            current = current.previous;
        }

        return -1;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<E> current = getNodeAt(index);
        E oldValue = current.element;
        current.element = e;
        return oldValue;
    }

    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public java.util.ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    public java.util.ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return new LinkedListIterator(index);
    }

    private class LinkedListIterator implements java.util.ListIterator<E> {
        private Node<E> current = head;
        private int index = 0;

        public LinkedListIterator() {
        }

        public LinkedListIterator(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }

            current = getNodeAt(index);
            this.index = index;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public boolean hasPrevious() {
            return (current != null && current.previous != null);
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next element");
            }

            E element = current.element;
            current = current.next;
            index++;
            return element;
        }

        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("No previous element");
            }

            if (current == null) {
                current = tail;
            } else {
                current = current.previous;
            }

            index--;
            return current.element;
        }

        public int nextIndex() {
            return index;
        }

        public int previousIndex() {
            return index - 
