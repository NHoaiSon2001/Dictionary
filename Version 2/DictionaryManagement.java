import java.io.File;
import java.io.FileNotFoundException;
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
}