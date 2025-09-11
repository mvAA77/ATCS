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
        String thisWord = "";
        for (int i = 0, i < word.size(); i++) {
            thisWord += word.pop();
        }

        for (int i = thisWord.length()-1; i >=0; i--) {
            word.push(thisWord.charAt(i));
        }
        String officialWord = "";
         for (int i = thisWord.length() - 1; i >= 0; i--) {
            officialWord += thisWord.charAt(i);
        }
        return officialWord;

    }

    
    public static void main(String[] args) {
        Stack stackie = new Stack(10);
    }
}
