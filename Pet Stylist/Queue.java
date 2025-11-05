public class Queue<T> {
    
    LinkedList<T> queue;
    
    public Queue() {
        
        queue = new LinkedList<T>();
    }
    
    public void offer(T elem) {
        queue.add(elem);
    }
    
    public T poll(){
        return queue.remove(0);
    }
    
    public T peek() {
        return queue.get(0);
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public int size() {
        return queue.size();
    }
    
    
}