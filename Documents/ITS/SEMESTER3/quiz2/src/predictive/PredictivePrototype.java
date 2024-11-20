package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PredictivePrototype {

    private static final String[] KEYPAD = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static String wordToSignature(String word) {
        StringBuffer signature = new StringBuffer();

        for (char ch : word.toLowerCase().toCharArray()) {
            boolean found = false;
            for (int i = 2; i < KEYPAD.length; i++) {
                if (KEYPAD[i].indexOf(ch) != -1) {
                    signature.append(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                signature.append(" ");
            }
        }

        return signature.toString();
    }

    public static Set<String> signatureToWords(String signature) {
        Set<String> words = new HashSet<>();
        try {
            File dictionary = new File("words"); // scan the words file
            Scanner scan = new Scanner(dictionary);
            while (scan.hasNextLine()) {
                String word = scan.nextLine().toLowerCase();
                if (isValidWord(word) && wordToSignature(word).equals(signature)) {
                    words.add(word);
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    }

    public static boolean isValidWord(String word) {
        for (char ch : word.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("wordToSignature")) {
                for (int i = 1; i < args.length; i++) {
                    System.out.print(wordToSignature(args[i]) + " ");
                }
                System.out.println();
            } else if (args[0].equals("signatureToWords")) {
                for (int i = 1; i < args.length; i++) {
                    System.out.println(args[i] + " : " + signatureToWords(args[i]));
                }
            }
        }
    }
}
