import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
            //Dictionary.words.add(new Word(word_target, word_explain));
        }
        stdSc.close();
    }
    
    /**
     * Insert word from file.
     */
    public static void  insertFromFile() {
        try {
            File inputFile = new File("dictionaries.txt");
            Scanner inputFileSc = new Scanner(inputFile, "UTF-8");
            while (inputFileSc.hasNext()) {
                String[] wordInfo = inputFileSc.nextLine().split("\\t");
                Dictionary.words.add(new Word(wordInfo[0].trim(), wordInfo[1].trim(), wordInfo[2].trim(), wordInfo[3].trim()));
            }
            inputFileSc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        }
        try {
            File inputFile = new File("historyDictionaries.txt");
            Scanner inputFileSc = new Scanner(inputFile, "UTF-8");
            while (inputFileSc.hasNext()) {
                String[] wordInfo = inputFileSc.nextLine().split("\\t");
                Dictionary.historyWords.add(new Word(wordInfo[0].trim(), wordInfo[1].trim(), wordInfo[2].trim(), wordInfo[3].trim()));
            }
            inputFileSc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        }
    }

    public static void dictionaryExportToFile() {
        try {
            OutputStream outputStream = new FileOutputStream("dictionaries.txt");
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            for (Word word : Dictionary.words) {
                String s = word.word_target + "\t" + word.word_type + "\t" + word.word_pronounce + "\t" + word.word_explain + "\n";
                writer.write(s);
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error");
        }
        try {
            OutputStream outputStream = new FileOutputStream("historyDictionaries.txt");
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            for (Word word : Dictionary.historyWords) {
                String s = word.word_target + "\t" + word.word_type + "\t" + word.word_pronounce + "\t" + word.word_explain + "\n";
                writer.write(s);
            }
            writer.close();
        } catch (IOException ex) {
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

    public static void addToHistory(Word word) {
        Dictionary.historyWords.remove(word);
        Dictionary.historyWords.add(0, word);
    }

    /**
     * Add new word.
     */
    public static void insertNewWord(Word newWord) {
        int l = -1;
        int r = Dictionary.words.size();
        int o;
        while (r - l > 1) {
            o = (l + r) / 2;
            if (Dictionary.words.get(o).word_target.compareTo(newWord.word_target) < 0) {
                l = o;
            } else {
                r = o;
            }
        }
        Dictionary.words.add(r, newWord);
    }

    public static void updateWord(Word updateWord, Word newWord) {
        for (int i = 0; i < Dictionary.words.size(); ++i) {
            if (Dictionary.words.get(i).equals(updateWord)) {
                Dictionary.words.set(i, newWord);
                break;
            }
        }
        for (int i = 0; i < Dictionary.historyWords.size(); ++i) {
            if (Dictionary.historyWords.get(i).equals(updateWord)) {
                Dictionary.historyWords.set(i, newWord);
                return;
            }
        }
    }
    /**
     * Remove word.
     */
    public static void removeWord(Word removeWord) {
        Dictionary.words.remove(removeWord);
        Dictionary.historyWords.remove(removeWord);
    }
    public static void main(String[] args) {
        DictionaryManagement.insertFromFile();
        DictionaryManagement.dictionaryExportToFile();
    }
}
/*
public static void  insertFromFile() {
        try {
            File inputFile = new File("dictionaries.txt");
            Scanner inputFileSc = new Scanner(inputFile, "UTF-8");
            while (inputFileSc.hasNext()) {
                String[] wordInfo = inputFileSc.nextLine().split("\\t");
                String word_target = "";
                String word_explain = wordInfo[wordInfo.length - 1];
                String word_pronounce = "";
                String word_type = "";
                for (int i = 0; i < wordInfo.length-1; ++i) {
                    String s = wordInfo[i].trim();
                    if (s.length() == 0) continue;
                    if (s.charAt(s.length() - 1) == '.' || s.charAt(s.length() - 1) == ',') {
                        word_type += " " + s;
                    }
                    else if (s.charAt(0) != '/' ){
                        word_target += " " + s;
                    }
                    if (i == wordInfo.length - 2 && s.charAt(0) == '/') {
                        word_pronounce = s;
                    }
                }
                Dictionary.words.add(new Word(word_target.trim(), word_type.trim(), word_pronounce.trim(), word_explain.trim()));
            }
            inputFileSc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        }
    }
 */