public class Node <T> {
    
    private T value = null;
    public Node nextNode;
    
    public Node(T data) {
        value = data;
        nextNode = null;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setNode(Node node) {
        nextNode = node;
    }
    
}