public class LinkedList<T> {
    
    private Node<T> header;
    private Node<T> tail;
    private int count;
    
    public LinkedList() {
        header = null;
        tail = null;
        count = 0;
    }
    
    public void add(T elem) {
        Node<T> newNode = new Node<T>(elem);
        if (isEmpty()) {
            header = newNode;
            tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        count++;
    }
        
    
    public T remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        
        T removedValue;
        
        if (index == 0) {
            removedValue = header.getValue();
            header = header.nextNode;
            if (header == null) {
                tail = null;
            }
        } else {
            Node<T> current = header;
            for (int i = 0; i < index - 1; i++) {
                current = current.nextNode;
            }
            
            removedValue = (T) current.nextNode.getValue();
            
            if (current.nextNode == tail) {
                tail = current;
            }
            current.nextNode = current.nextNode.nextNode;
        }
        
        count--;
        return removedValue;
    }
    
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        
        Node<T> current = header;
        for (int i = 0; i < index; i++) {
            current = current.nextNode;
        }
        return current.getValue();
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public int size() {
        return count;
    }
    
    public void print() {
        Node<T> current = header;
        System.out.print("LinkedList: ");
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.nextNode;
        }
        System.out.println();
    }
    
    public int contains(T elem) {
        Node<T> current = header;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(elem)) {
                return index;
            }
            current = current.nextNode;
            index++;
        }
        return -1;
    }
    
    public boolean removeFirst(T elem) {
        if (isEmpty()) {
            return false;
        }
        
        if (header.getValue().equals(elem)) {
            remove(0);
            return true;
        }
        
        Node<T> current = header;
        while (current.nextNode != null) {
            if (current.nextNode.getValue().equals(elem)) {
                if (current.nextNode == tail) {
                    tail = current;
                }
                current.nextNode = current.nextNode.nextNode;
                count--;
                return true;
            }
            current = current.nextNode;
        }
        
        return false;
    }
    
    public void insert(int pos, T elem) {
        if (pos < 0 || pos > count) {
            throw new IndexOutOfBoundsException("Index: " + pos + ", Size: " + count);
        }
        
        if (pos == count) {
            add(elem);
            return;
        }
        
        Node<T> newNode = new Node<T>(elem);
        
        if (pos == 0) {
            newNode.nextNode = header;
            header = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            Node<T> current = header;
            for (int i = 0; i < pos - 1; i++) {
                current = current.nextNode;
            }
            newNode.nextNode = current.nextNode;
            current.nextNode = newNode;
        }
        count++;
    }
}