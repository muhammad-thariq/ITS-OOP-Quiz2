package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DictionaryListImpl implements Dictionary {
    private List<WordSig> dictionary;

    public DictionaryListImpl(String filePath) {
        dictionary = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                if (PredictivePrototype.isValidWord(word)) {
                    dictionary.add(new WordSig(word));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(dictionary);
    }

    @Override
    public Set<String> signatureToWords(String signature) {
        Set<String> words = new TreeSet<>();
        WordSig sigKey = new WordSig("");
        sigKey.signature = signature;
        int index = Collections.binarySearch(dictionary, sigKey);
        if (index < 0) {
            index = -index - 1;
        }
        while (index < dictionary.size() && dictionary.get(index).getSignature().equals(signature)) {
            words.add(dictionary.get(index).getWord());
            index++;
        }
        return words;
    }
}
