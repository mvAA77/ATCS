public class IntPair {
    
    public int min;
    public int max;
    public String name;
    
    public IntPair(int min, int max, String name) {
        this.min = min;
        this.max = max;
        this.name = name;
    }
    
    public boolean inRange(int num) {
        if ((min <= num) && (num <= max)) {
            return true;
        } else {
            return false;
        }
    }
}