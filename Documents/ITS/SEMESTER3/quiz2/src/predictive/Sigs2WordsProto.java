package predictive;

public class Sigs2WordsProto {

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String signature : args) {
                System.out.println(signature + " : " + PredictivePrototype.signatureToWords(signature));
            }
        } else {
            System.out.println("Usage: java predictive.Sigs2WordsProto <signature1> <signature2> ...");
        }
    }
}
