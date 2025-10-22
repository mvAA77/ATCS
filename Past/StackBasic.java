package Past;
import java.util.Arrays;

public class StackBasic {
    private int[] stack;
    private int len;
    private int count;

    public StackBasic(int size) {
        stack  = new int[size];
        len = size;
        count = 0;
    }

    public StackBasic(int[] stack) {
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
            System.out.println(stack[count-1]);
            return stack[count-1];
        } catch (Exception e) {
            System.out.println("Failed. Empty Stack Error");
            return -1;
        }
    }

    public int pop() {
        try{
            int value = stack[count-1];
            stack[count-1] = 0;
            count = count - 1;
            System.out.println(value);
            return value;
        } catch (Exception e) {
            System.out.println("Sorry! There has been an error");
            return -1;
        }
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

    /* if (count == 0) {
     * return true;
     * } else {
     * return false;}
    } */
}