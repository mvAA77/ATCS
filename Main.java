///import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        
        Stack newStack = new Stack(10);

        System.out.println(newStack.isEmpty());

        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int value = r.nextInt(100);
            //System.out.println(value);
            newStack.push(value);
            //System.out.println(newStack.peek());
        }

        //System.out.println(newStack.size());
        //System.out.println(newStack.isEmpty());
        //System.out.println(newStack.peek());
        //System.out.println(newStack.pop());
        System.out.println(newStack.isEmpty());
        System.out.println(newStack.peek());

    }
}
