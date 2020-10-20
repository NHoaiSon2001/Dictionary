public class Word {
    public String word_target; //word
    public String word_explain; //mean of word
    public String word_pronounce;
    public String word_type;

    /**
     * Constructor.
     */
    public Word(String word_target, String word_type, String word_pronounce, String word_explain) {
        this.word_target = word_target;
        this.word_type = word_type;
        this.word_pronounce = word_pronounce;
        this.word_explain = word_explain;
    }

    @Override
    public String toString() {
        return word_target;
    }
    public static void main(String[] args) {
        
    }
}