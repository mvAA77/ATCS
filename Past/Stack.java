package past;
import java.util.Arrays;

public class Stack <T> {

    private T[] stack;
    private int len;
    private int count;

    public Stack(int size) {
        stack  = (T[]) new Object[size];
        len = size;
        count = 0;
    }

    public Stack(T[] stack) {
        this.stack  = stack;
        len = stack.length;
        count = len;
    }

    public void grow() {
        len = (int)(len * 1.5);
        stack = Arrays.copyOf(stack, len);
    }

    public void push(T t) {
        int prevLen = len;
        if (count >= len) {
            grow();
            stack[prevLen] = t;
            //System.out.println(stack[prevLen]);
            count++;
        } else {
            stack[count] = t;
            //System.out.println(stack[count]);
            count++;
        }
    }

    public T peek() {
        try {
            System.out.println(stack[count-1]);
            return stack[count-1];
        } catch (Exception e) {
            System.out.println("Failed. Empty Stack Error");
            return null;
        }
    }

    public T pop() {
        try{
            T value = stack[count-1];
            stack[count-1] = null;
            count = count - 1;
            System.out.println(value);
            return value;
        } catch (Exception e) {
            System.out.println("Sorry! There has been an error");
            return null;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {

        if (count == 0) {
            return true;
        } else {
            return false;}

    }

    public static void main(String[] args) {
        
    }
}
