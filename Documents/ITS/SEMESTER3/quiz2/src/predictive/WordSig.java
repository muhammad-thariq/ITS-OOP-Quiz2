package predictive;

public class WordSig implements Comparable<WordSig> {
    private String word;
    public String signature;

    public WordSig(String word) {
        this.word = word.toLowerCase();
        this.signature = PredictivePrototype.wordToSignature(this.word);
    }

    public String getWord() {
        return word;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public int compareTo(WordSig other) {
        return this.signature.compareTo(other.signature);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WordSig wordSig = (WordSig) obj;
        return word.equals(wordSig.word) && signature.equals(wordSig.signature);
    }

    @Override
    public int hashCode() {
        return word.hashCode() * 31 + signature.hashCode();
    }

    @Override
    public String toString() {
        return word + ":" + signature;
    }
}
