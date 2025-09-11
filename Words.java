import java.util.Random;

public class Words {

    private Stack word;
    Random random = new Random();
    private int rand;
    private String[] themes = {"Pets", "Pool Party Food", "Birds", "Colors", "Vacation Spots", "Instruments"};
    private String theme;


    public Words() {
        rand = (int)(Math.random() * ((5) + 1)) + 5;
        word = new Stack(rand);

        int randTheme = random.nextInt(5);
        theme = themes[randTheme];

    }

    public int getSpaces() {
        return rand;
    }

    public String getTheme() {
        return theme;
    }

    public Stack getWord() {
        return word;

    }

    
    public static void main(String[] args) {
        Stack stackie = new Stack(10);
    }
}
