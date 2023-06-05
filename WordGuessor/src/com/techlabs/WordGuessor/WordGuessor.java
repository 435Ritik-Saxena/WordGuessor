package com.techlabs.WordGuessor;
import java.util.*;
public class WordGuessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        String letters = "abcdefghijklmnopqrstuvwxyz";
        int wordLength = getRandomNumber(1, letters.length());
        String word = generateRandomWord(letters, wordLength);
        int chances = 2 * word.length();
        char[] blanks = new char[word.length()];
        boolean[] guessedLetters = new boolean[word.length()];
        initializeBlanks(blanks);
        while (true) {
            System.out.println("Word: " + String.valueOf(blanks));
            System.out.println("Chances remaining: " + chances);
            System.out.print("Guess a letter: ");
            char guessedLetter = scanner.nextLine().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guessedLetter && !guessedLetters[i]) {
                    blanks[i] = guessedLetter;
                    guessedLetters[i] = true;
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                if (isWordGuessed(guessedLetters)) {
                    System.out.println("\nCongratulations! You guessed the word: " + word);
                    break;
                }
            } else {
                chances--;
                System.out.println("Incorrect guess!");
                if (chances == 0) {
                    System.out.println("\nGame over! You ran out of chances.");
                    System.out.println("The word was: " + word);
                    break;
                }
            }

            System.out.println();
        }
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static String generateRandomWord(String letters, int wordLength) {
        StringBuilder word = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < wordLength; i++) {
            int index = random.nextInt(letters.length());
            char letter = letters.charAt(index);
            word.append(letter);
        }

        return word.toString();
    }

    public static void initializeBlanks(char[] blanks) {
        for (int i = 0; i < blanks.length; i++) {
            blanks[i] = '_';
        }
    }

    public static boolean isWordGuessed(boolean[] guessedLetters) {
        for (boolean guessed : guessedLetters) {
            if (!guessed) {
                return false;
            }
        }
        return true;
    }
}
