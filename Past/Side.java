/*package Past;
///import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        
        StackBasic newStack = new StackBasic(10);

        // Reports correctly even with array full of default values
        System.out.println(newStack.isEmpty());

        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int value = r.nextInt(100);
            //System.out.println(value);
            // Accounts for an odd length when growing; also accounts if index is equal to length
            newStack.push(value);
            //System.out.println(newStack.peek());
        }
        System.out.println(newStack.isEmpty());
        newStack.peek();
        newStack.pop();
        System.out.println(newStack.isEmpty());
        for (int s = 0; s < 18; s++) {
            newStack.pop();

        }
        System.out.println(newStack.isEmpty());
        // Checks if pop/peek works on empty stack
        newStack.pop();
        newStack.peek();
        System.out.println(newStack.isEmpty());
        
        // Returns correct size even when stack is empty
        System.out.println(newStack.size());
        


    }
}
*/