package wbpsolution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static wbpsolution.Metrics.gatherPerformance;
import static wbpsolution.Metrics.printMethodName;

/**
 * This class provides operations on words dictionary.
 */
public class WordsHandler {

    //region readFromFile

    /**
     * Method reads all lines from the file using stream.
     *
     * @return Words dictionary
     */
    public static HashSet<String> getWordsFromFile(String fileName) throws IOException {
        long startTime = System.currentTimeMillis();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        HashSet<String> dictionary = new HashSet<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(word -> dictionary.add(word));
        } catch (Exception e) {
            e.printStackTrace();
        }

        printMethodName(methodName);
        gatherPerformance();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of method %s() is %d %s\n", methodName, elapsedTime, "ms\n");

        return dictionary;
    }

    //endregion

    //region Words handling

    /**
     * Method checks if a word is concatenated of multiple words.
     * @param word A word to check.
     * @param dictionary Dictionary of all words from file.
     * @param filledConcList List that will be filled with concatenated words.
     * @return Recursively returns value of true if dictionary contains prefix and suffix is also concatenated, otherwise returns false.
     */
    private static boolean isConcatenated(String word, Set<String> dictionary, ArrayList<String> filledConcList) {
        String prefix;
        String suffix;
        for (int i = 0; i <= word.length()-1 ; i++) {
            prefix = word.substring(0, i+1);
            suffix = word.substring(i+1);
            if (dictionary.contains(prefix)) {
                if (dictionary.contains(suffix)) {
                    filledConcList.add(word);
                    break;
                }
                isConcatenated(suffix, dictionary, filledConcList);
            }
        }
        return false;
    }

    /**
     * @param dictionary Dictionary of all words from file.
     * @param filledConcList
     * @return Returns the list of concatenated words for calculation of longest and second longest concatenated words.
     */
    public static ArrayList<String> findConcatenatedWords(Set<String> dictionary, ArrayList<String> filledConcList) {

        long startTime = System.currentTimeMillis();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


        dictionary.forEach(word -> {
            try {
                isConcatenated(word, dictionary, filledConcList);
            } catch (NullPointerException e) {
                System.out.println("The word was equal to null.");
            }
        });

        printMethodName(methodName);
        gatherPerformance();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of method %s() is %d %s\n", methodName, elapsedTime, "ms\n");

        return filledConcList;

    }

    /**
     * @param concatenatedWords The list of concatenated words.
     * @return Returns longest and second longest concatenated word in a dictionary.
     */
    public static ArrayList<String> findLongestConcatenatedWords(ArrayList<String> concatenatedWords) {
        long startTime = System.currentTimeMillis();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        ArrayList<String> longestWords = new ArrayList<>();

        concatenatedWords.sort(Comparator.comparing(String::length).reversed());

        try {
            longestWords.add(concatenatedWords.get(0));
            longestWords.add(concatenatedWords.get(1));
        }
        catch (IndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }

        printMethodName(methodName);
        gatherPerformance();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of method %s() is %d %s\n", methodName, elapsedTime, "ms\n");

        return longestWords;
    }

    //endregion
}