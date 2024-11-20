package predictive;

public class Words2SigProto {

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String word : args) {
                System.out.print(PredictivePrototype.wordToSignature(word) + " ");
            }
            System.out.println();
        } else {
            System.out.println("Usage: java predictive.Words2SigProto <word1> <word2> ...");
        }
    }
}
