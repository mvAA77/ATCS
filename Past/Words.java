package Past;
import java.util.Random;
import java.util.Scanner;

public class Words {

    private Stack words;
    Random random = new Random();
    private String[] themes = {"Pets", "Pool Party Food", "Birds", "Colors", "Vacation Spots", "Instruments"};
    private String theme;

    public Words() {
        words = new Stack(5);
        int randTheme = random.nextInt(themes.length);
        theme = themes[randTheme];
    }

    public int getLength() {
        return words.size();
    }

    public String getTheme() {
        return theme;
    }

    public Object getLastWord() {

        if (words.isEmpty()) {
            return "";
        } else {
            return words.peek();
        }
    }

    public void deletePrevious() {
        if (!words.isEmpty()) {
            words.pop();
        }
    }

    public void addWord(String word) {
        words.push(word);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Words wordle = new Words();
        System.out.println("Welcome to Theme Words!");
        System.out.println("This is your theme: " + wordle.getTheme());

        System.out.println("Please enter a word that fits this theme.");
        System.out.println("Next, input another word that starts with the same letter the previous word ended in");
        System.out.println("Press # if you can't think of any new words!");
        System.out.println("If you want to undo your input, please press: ! ");
        System.out.println("Good Luck!");
        
        // Get the first word
        System.out.print("Word: ");
        String userWord = input.nextLine().toLowerCase();
        wordle.addWord(userWord);

        while (true) {
            System.out.print("Great! Please enter another word: ");
            userWord = input.nextLine().toLowerCase();
    
            if (userWord.equals("#")) {
                break;
            }
    
            if (userWord.equals("!")) {
                wordle.deletePrevious();
                if (wordle.getLength() > 0) {
                    System.out.println("Undo successful. Last word was: " + wordle.getLastWord());
                } else {
                    System.out.println("No words to undo. Please enter a new word.");
                }
                continue;
            }
            
            // Check if the word fits the theme (simple check)
            String lastWord = String.valueOf(wordle.getLastWord());
            if (lastWord.isEmpty()) {
                wordle.addWord(userWord);
                continue;
            }
            
            char lastCharPrevious = lastWord.charAt(lastWord.length() - 1);
            char firstCharCurrent = userWord.charAt(0);
    
            if (lastCharPrevious == firstCharCurrent) {
                wordle.addWord(userWord);
                System.out.println("Good job! The word '" + userWord + "' was added.");
            } else {
                System.out.println("Word doesn't match! Last letter was: " + lastCharPrevious);
                System.out.println("Try again or press # to end the game.");
            }
        }

        System.out.println("You're Done! Your score is: " + wordle.getLength());
        input.close();
    }
}