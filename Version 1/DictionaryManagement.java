import java.util.Scanner;

public class DictionaryManagement {
    /**
     * Insert word from commandline.
     */
    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; ++i) {
            String word_target = sc.nextLine();
            String word_explain = sc.nextLine();
            Dictionary.words.add(new Word(word_target, word_explain));
        }
    }
}