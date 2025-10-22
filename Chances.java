import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class Chances {
    
    private static final Logger LOGGER = Logger.getLogger(Chances.class.getName());
    
    private LinkedList<Integer> numbers = new LinkedList<Integer>();
    private LinkedList<String> names = new LinkedList<String>();
    
    private LinkedList<IntPair> map = new LinkedList<IntPair>();
    

    
    public Integer calculateChances(String path) {
        String filePath = path;
        int total = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Integer lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (lineNumber % 4 == 2) {
                    //System.out.println(line);
                    int num = Integer.parseInt(line);
                    total += num;
                    numbers.add(num);
                } else if (lineNumber % 4 == 1) {
                    //System.out.println(line);
                    names.add(line);
                }
            }
        } catch (IOException e) {
            LOGGER.severe("Error reading the file: " + e.getMessage());
        }
        return total;
        }
        
    
    
    
    private void makeList() {
        calculateChances("Animals.txt");
        int add = 0;
        for (int i = 0; i < numbers.size(); i++) {
            map.add(new IntPair(add, add + numbers.get(i), names.get(i)));
            add += numbers.get(i);
        }
    }
    
    public String randomWeekly(){
        int weekMins = 2400;
        calculateChances("Animals.txt");
        makeList();
        
        java.util.Random random = new java.util.Random();
        int rand = random.nextInt(weekMins) + 1;
        
        boolean check = false;
        int index = 0;
        
        while (!check) {
            index++;
            try {
                IntPair current = map.get(index);
                check = current.inRange(rand);
            } catch (IndexOutOfBoundsException _) {
                return "No Animal";
            }

        }
        
        return map.get(index).name;
        
    }
    
    
    
    
    
    
}