public class Main {
    
        public static void main(String[] args) {
        Salon sim = new Salon();

        for (int stylists = 4; stylists <= 10; stylists++) {
            int successCount = 0;

            for (int run = 0; run < 1000; run++) {
                boolean success = sim.runSimulation(stylists);
                if (success) successCount++;
            }

            double successRate = (successCount / 1000.0) * 100;
            System.out.println(stylists + " stylists → " + successRate + "% success");
        }
    }

}
