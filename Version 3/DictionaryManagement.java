import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class DictionaryManagement {
    /**
     * Insert word from commandline.
     */
    public static void insertFromCommandline() {
        Scanner stdSc = new Scanner(System.in);
        int n = stdSc.nextInt();
        stdSc.nextLine();
        for (int i = 0; i < n; ++i) {
            String word_target = stdSc.nextLine();
            String word_explain = stdSc.nextLine();
            Dictionary.words.add(new Word(word_target, word_explain));
        }
        stdSc.close();
    }

    /**
     * Insert word from file.
     */
    public static void  insertFromFile() {
        try {
            File inputFile = new File("dictionaries.txt");
            Scanner inputFileSc = new Scanner(inputFile);
            while (inputFileSc.hasNext()) {
                String word_target = inputFileSc.next().trim();
                String word_explain = inputFileSc.nextLine().trim();
                Dictionary.words.add(new Word(word_target, word_explain));
            }
            inputFileSc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        }
    }

    public static void dictionaryExportToFile() {
        try {
            Formatter fr = new Formatter("dictionaries.txt");
            for (Word word : Dictionary.words) {
                fr.format("%s   %s\n", word.word_target, word.word_explain);
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        }
    }
    /**
     * Lookup word.
     */
    public static void dictionaryLookup() {
        Scanner stdSc = new Scanner(System.in);
        System.out.print("Word: ");
        String lookupWord = stdSc.nextLine();
        for (Word word : Dictionary.words) {
            if (word.word_target.equals(lookupWord)) {
                System.out.println("Mean: " + word.word_explain);
                return;
            }
        }
        System.out.println("Not found");
    }

    /**
     * Add new word.
     */
    public static void insertNewWord(Word newWord) {
        Dictionary.words.add(newWord);
    }

    public static void updateWord(String updateWord, Word newWord) {
        for (Word word : Dictionary.words) {
            if (word.word_target.equals(updateWord)) {
                word = newWord;
            }
        }
    }
    /**
     * Remove word.
     */
    public static void removeWord(String removeWord) {
        for (Word word : Dictionary.words) {
            if (word.word_target.equals(removeWord)) {
                Dictionary.words.remove(word);
            }
        }
    }
}