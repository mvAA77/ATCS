import java.util.ArrayList;
import java.util.Random;
import java.util.List;


public class PartTwo {


    public PartTwo() {

        List<Integer>[] arrayLists = new ArrayList[10];
        ArrayList<Integer> arrayLengths = new ArrayList<>(); 

        ArrayList<Long> times = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int len = random.nextInt(1000) + 180;
            arrayLengths.add(Integer.valueOf(len));
            long startTime = System.nanoTime();
            for (int j = 0; j < len; j++) {
                int item = random.nextInt(100) + 1;
                arrayLists[i].add(item);
            }
            long endTime = System.nanoTime();
            long timeElapsed1 = endTime - startTime;
            arrayLengths.add(len);
            times.add(timeElapsed1);

        }
    }




}