import java.util.Arrays;

public class Stack {
    private int[] stack;
    private int len;
    private int count;

    public Stack(int size) {
        stack  = new int[size];
        len = size;
        count = 0;
    }

    public Stack(int[] stack) {
        this.stack  = stack;
        len = stack.length;
        count = len;
    }

    public void grow() {
        len = (int)(len * 1.5);
        stack = Arrays.copyOf(stack, len);
    }

    public void push(int e) {
        int prevLen = len;
        if (count >= len) {
            grow();
            stack[prevLen] = e;
            //System.out.println(stack[prevLen]);
            count++;
        } else {
            stack[count] = e;
            //System.out.println(stack[count]);
            count++;
        }
    }

    public int peek() {
        try {
            return stack[count-1];
        } catch (Exception e) {
            System.out.println("Failed. Empty Stack Error");
            return -1;
        }
    }

    public int pop() {
        int value = stack[len-1];
        stack[len-1] = 0;
        count = count - 1;
        return value;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        for (int i = 0; i < len; i++) {
            if (!(stack[i] == 0)) {
                return false;
            }
        }

        return true;
    }

}