import java.util.Scanner;

public class DictionaryCommandline {
    /**
     * Show all words.
     */
    public static void showAllWords() {
        System.out.println("No      |English     |Vietnamese");
        int ordinal = 1;
        for (Word word : Dictionary.words) {
            System.out.println(ordinal + "       |" + word.word_target + "       |" + word.word_explain);
            ordinal++;
        }
    }

    /**
     * Insert word from commandline and show all words.
     */
    public static void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    /**
     * Search word.
     */
    public static void dictionarySearcher() {
        Scanner stdsc = new Scanner(System.in);
        String searchWord = stdsc.nextLine();
        for (Word word : Dictionary.words) {
            if (word.word_target.length() >= searchWord.length() && searchWord.equals(word.word_target.substring(0, searchWord.length()))) {
                System.out.println(word.word_target);
            }
        }
    }

    /**
     * Insert word from file, show all words and lookup word.
     */
    public static void dictionaryAdvanced() {
        DictionaryManagement.insertFromFile();
        dictionarySearcher();
        DictionaryManagement.dictionaryExportToFile();
    }

    /**
     * main.
     */
    public static void main(String[] args) {
        DictionaryCommandline.dictionaryAdvanced();
    }
}