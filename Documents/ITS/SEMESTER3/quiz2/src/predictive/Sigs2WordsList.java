package predictive;

public class Sigs2WordsList {

    public static void main(String[] args) {
        if (args.length > 1) {
            String filePath = args[0];  // First argument is the file path
            DictionaryListImpl dictionary = new DictionaryListImpl(filePath);
            System.out.println("Input signatures to convert to words:");
            for (int i = 1; i < args.length; i++) {
                System.out.println(args[i] + " : " + dictionary.signatureToWords(args[i]));
            }
        } else {
            System.out.println("Usage: java predictive.Sigs2WordsList <file_path> <signature1> <signature2> ...");
        }
    }
}
