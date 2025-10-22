import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Salon {
    private static final int YEAR_MINUTES = 124800; // 8h * 5d * 52w * 60m

    private Chances chances;

    // care times loaded from file
    private LinkedList<Integer> careTimes = new LinkedList<Integer>();
    private LinkedList<String> names = new LinkedList<String>();

    public Salon() {
        chances = new Chances();
        fillLists(); // load animal care times
    }

    public boolean runSimulation(int numStylists) {
        Queue<Pet> waitingPets = new Queue<>();
        Stylist head = createStylists(numStylists);

        for (int minute = 0; minute < YEAR_MINUTES; minute++) {
            // 1. Determine if an animal arrives (driven by Chances)
            String species = chances.randomWeekly();

            // 2. If a real animal arrives, add to queue
            if (!species.equals("No Animal")) {
                int careTime = getCareTime(species);
                if (careTime > 0) {
                    waitingPets.offer(new Pet(species, careTime));
                }
            }

            // 3. Stylists work
            Stylist current = head;
            while (current != null) {
                current.workOneMinute();

                if (current.isFree() && !waitingPets.isEmpty()) {
                    current.assign(waitingPets.poll());
                }

                current = current.next;
            }
        }

        // simulation success if no pets left waiting
        return waitingPets.isEmpty();
    }

    // create linked stylists
    private Stylist createStylists(int count) {
        Stylist head = new Stylist();
        Stylist current = head;
        for (int i = 1; i < count; i++) {
            Stylist next = new Stylist();
            current.next = next;
            current = next;
        }
        return head;
    }

    // read care times (line 3 of every 4 lines)
    private void fillLists() {
        String filePath = "Animals.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (lineNumber % 4 == 1) {
                    names.add(line.trim());
                } else if (lineNumber % 4 == 3) {
                    int time = Integer.parseInt(line.trim());
                    careTimes.add(time);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // lookup species → care time
    private int getCareTime(String species) {
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.equalsIgnoreCase(species)) {
                return careTimes.get(i);
            }
        }
        return -1;
    }
}
