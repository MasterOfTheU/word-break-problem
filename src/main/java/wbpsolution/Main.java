package wbpsolution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import static wbpsolution.WordsHandler.*;


public class Main {

    public static void main(String[] args) throws IOException {

        Set<String> dictionary = getWordsFromFile("words.txt");

        ArrayList<String> concatenatedWords = findConcatenatedWords(dictionary, new ArrayList<>());
        ArrayList<String> longestConcatenatedWords = findLongestConcatenatedWords(concatenatedWords);

        System.out.printf("LONGEST WORD FROM FILE IS: %s\n", longestConcatenatedWords.get(0));
        System.out.printf("SECOND LONGEST WORD FROM FILE IS: %s\n", longestConcatenatedWords.get(1));
        System.out.printf("TOTAL NUMBER OF CONCATENATED WORDS: %d\n", concatenatedWords.size());

    }

}
