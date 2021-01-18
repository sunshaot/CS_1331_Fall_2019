//I worked on the homework assignment alone, using only course materials.
/**
 * This class represent MyLinkedList
 * @author Shaotong Sun
 * @version 16.0.1
 * @param <E> generic data type
 */
public class MyLinkedList<E> implements SimpleList<E> {
    /*
        DO NOT MODFIY THIS PART
    */
    private class Node {
        private E data;
        private Node next;
        private Node prev;
        private Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    /*
        IMPLEMENT THE METHODS BELOW:
     */

    /**
     * Add element to a specific index.
     *
     * You can use this method to add to the end of a list.
     * This does NOT remove the element at an existing index.
     *
     * @param index   Index to add element to
     * @param element Element to be added
     * @throws NullPointerException     If element is null
     * @throws IllegalArgumentException If index is negative or greater than size
     */
    @Override
    public void add(int index, E element) throws NullPointerException, IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        } else if (element == null) {
            throw new NullPointerException();
        } else {
            if (index == 0) {
                add(element);
            } else if (index == size) {
                Node newNode = new Node(element);
                if (tail == null) {
                    head = newNode;
                    tail = newNode;
                    newNode.prev = null;
                    newNode.next = null;
                } else {
                    tail.next = newNode;
                    newNode.prev = tail;
                    newNode.next = null;
                    tail = newNode;
                }
                size++;
            } else {
                Node current = head;
                for (int i = 1; i < index; i++) {
                    current = current.next;
                }
                Node temp = current.next;
                Node newNode = new Node(element);
                current.next = newNode;
                newNode.prev = current;
                newNode.next = temp;
                temp.prev = newNode;
                size++;
            }
        }
    }

    /**
     * Add element to the beginning of the list.
     *
     * @param element Element to be added
     * @throws NullPointerException If element is null
     */
    @Override
    public void add(E element) {
        if (element == null) {
            throw new NullPointerException();
        } else {
            Node newNode = new Node(element);
            if (head == null) {
                head = newNode;
                tail = newNode;
                newNode.next = null;
                newNode.prev = null;
            } else {
                head.prev = newNode;
                newNode.next = head;
                newNode.prev = null;
                head = newNode;
            }
            size++;
        }
    }

    /**
     * Retrieve element at a specific index.
     *
     * This method should not modify the list.
     *
     * @param index Index to fetch element from
     * @return Element fetched from list
     * @throws IllegalArgumentException If index is negative or if index is greater than or equal to size
     */
    @Override
    public E get(int index) throws IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        } else {
            Node current = head;
            E data = null;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    data = current.data;
                    break;
                }
                current = current.next;
            }
            return data;
        }
    }

    /**
     * Remove element at a specific index.
     *
     * @param index Index to remove element from
     * @throws IllegalArgumentException If index is negative or if index is greater than or equal to size
     */
    @Override
    public void remove(int index) throws IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        } else {
            if (index == 0) {
                if (size > 0) {
                    head = head.next;
                    size--;
                    if (head == null) {
                        tail = head;
                    } else {
                        head.prev = null;
                    }
                }
            } else if (index == size - 1) {
                if (size > 0) {
                    if (size == 1) {
                        head = null;
                        tail = null;
                        size--;
                    } else {
                        Node current = head;
                        for (int i = 0; i < size - 2; i++) {
                            current = current.next;
                        }
                        tail = current;
                        tail.next = null;
                        size--;
                    }
                }
            } else {
                Node previous = head;
                for (int i = 1; i < index; i++) {
                    previous = previous.next;
                }
                Node current = previous.next;
                previous.next = current.next;
                (previous.next).prev = previous;
                size--;
            }
        }
    }

    /**
     * Remove the first instance of the element from the list.
     *
     * If the element does not exist in the list, do nothing.
     *
     * @param element Element to find and remove.
     * @throws NullPointerException If element is null
     */
    @Override
    public void removeElement(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        } else if (contains(element)) {
            Node current = head;
            for (int i = 0; i < size; i++) {
                if ((current.data).equals(element)) {
                    remove(i);
                    break;
                }
                current = current.next;
            }
        }
    }

    /**
     * Return whether the list contains a specific element.
     *
     * @param element Element to search for
     * @return True only if the element is found.
     * @throws NullPointerException If element is null
     */
    @Override
    public boolean contains(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        } else {
            boolean result = false;
            Node current = head;
            for (int i = 0; i < size; i++) {
                if (current.data == element) {
                    result = true;
                    break;
                }
                current = current.next;
            }
            return result;
        }
    }

    /**
     * Return whether the list is empty.
     *
     * @return True only if the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Remove all elements from the list.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Return the size of the list.
     *
     * @return the size of the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Creates and returns an array with the same elements as this list
     *
     * @return An array with all of the elements which is the same size as the list
     */
    @Override
    public Object[] toArray() {
        Object[] list = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            list[i] = current.data;
            current = current.next;
        }
        return list;
    }
}
