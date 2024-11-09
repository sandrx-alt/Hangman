import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;


    public class Hangman {
    public static void main(String[] args) {
        String[] words = {"java", "skillmea", "programovanie", "hra"};
        String word = words[(int) (Math.random() * words.length)];
        char[] guessed  = new char[word.length()];
        for (int i = 0; i < guessed.length; i++) {
            guessed[i] = '-';
        }

        Scanner scanner = new Scanner(System.in);
        int attempts = 6;

        while (attempts > 0) {
            System.out.println("word" + String.valueOf(guessed));
            System.out.println("Remaining attempts" + attempts);
            System.out.println("Guess the letter");
            char guess = scanner.next().toLowerCase().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessed[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attempts--;
            }

            if (String.valueOf(guessed).equals(word)) {
                System.out.println("You won the word was:" + word);
                break;
            }
        }

        if (attempts == 0) {
            System.out.println("You lose the word was:" + word);
        }

        scanner.close();
    }
}
