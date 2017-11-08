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

        printListInfo(concatenatedWords, longestConcatenatedWords);
    }

    public static boolean printListInfo(ArrayList<String> concatenatedWords, ArrayList<String> longestConcatenatedWords) {
        System.out.printf("LONGEST WORD FROM FILE IS: %s\n", getLongestWord(longestConcatenatedWords));
        System.out.printf("SECOND LONGEST WORD FROM FILE IS: %s\n", getSecondLongestWord(longestConcatenatedWords));
        System.out.printf("TOTAL NUMBER OF CONCATENATED WORDS: %d\n", getTotalNumberOfWords(concatenatedWords));
        return true;
    }

    public static String getLongestWord(ArrayList<String> longestConcatenatedWords) {
        return longestConcatenatedWords.get(0);
    }

    public static String getSecondLongestWord(ArrayList<String> longestConcatenatedWords) {
        return longestConcatenatedWords.get(1);
    }

    public static int getTotalNumberOfWords(ArrayList<String> concatenatedWords) {
        return concatenatedWords.size();
    }
}
