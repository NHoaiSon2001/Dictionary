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
     * Insert word from file, show all words and lookup word.
     */
    public static void dictionaryAdvanced() {
        DictionaryManagement.insertFromFile();
        showAllWords();
        DictionaryManagement.dictionaryLookup();
    }

    /**
     * main.
     */
    public static void main(String[] args) {
        DictionaryCommandline.dictionaryAdvanced();
    }
}