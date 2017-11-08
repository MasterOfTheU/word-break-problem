package testing;

import org.junit.Before;
import org.junit.Test;
import wbpsolution.Main;
import wbpsolution.WordsHandler;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static wbpsolution.Main.*;
import static wbpsolution.WordsHandler.*;

public class MainTest {

    private ArrayList<String> concatenatedWords;
    private ArrayList<String> longestConcatenatedWords;

    @Before
    public void init() throws Exception {
        Set<String> dictionary = getWordsFromFile("test.txt");
        concatenatedWords = findConcatenatedWords(dictionary, new ArrayList<>());
        longestConcatenatedWords = findLongestConcatenatedWords(concatenatedWords);
    }

    @Test
    public void testPrintListInfo() {
        assertTrue(printListInfo(concatenatedWords, longestConcatenatedWords));
    }

    @Test
    public void testFindLongestConcatenatedWord()  {
        ArrayList<String> longestConcatenatedWords = findLongestConcatenatedWords(concatenatedWords);
        String expected = "aasvogels";
        String actualResult = getLongestWord(longestConcatenatedWords);
        assertEquals(expected, actualResult);
    }

    @Test
    public void testFindSecondLongestConcatenatedWord()  {
        ArrayList<String> longestConcatenatedWords = findLongestConcatenatedWords(concatenatedWords);
        String expected = "aardvarks";
        String actualResult = getSecondLongestWord(longestConcatenatedWords);
        assertEquals(expected, actualResult);
    }

    @Test
    public void testGetTotalNumberOfWords() {
        assertTrue(concatenatedWords.size() > 0);
    }

}