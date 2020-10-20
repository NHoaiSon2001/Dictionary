import javax.swing.DefaultListModel;
import javax.swing.JTextArea;

import java.util.LinkedList;
import java.util.List;

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
    public static void dictionarySearcher(String searchText, DefaultListModel<Word> word_targetListModel, List<Word> searchListWord) {
        word_targetListModel.clear();
        for (Word word : searchListWord) {
            if (word.word_target.contains(searchText)) {
                word_targetListModel.addElement(word);
            }
        }
    }
}