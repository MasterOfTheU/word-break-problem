package testing;

import org.junit.Before;
import org.junit.Test;
import wbpsolution.WordsHandler;

import java.util.ArrayList;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;
import static wbpsolution.WordsHandler.*;


public class WordsHandlerTest {
    private Set<String> dictionary;
    private ArrayList<String> concatenatedWords;

    @Before
    public void init() throws Exception {
        dictionary = WordsHandler.getWordsFromFile("test.txt");
        concatenatedWords = findConcatenatedWords(dictionary, new ArrayList<>());
    }

    @Test
    public void getWordsFromFile() {
        assertThat(dictionary, is(not(empty())));
    }

    @Test
    public void testFindConcatenatedWords() {
        ArrayList<String> concatenatedWords = findConcatenatedWords(dictionary, new ArrayList<>());
        assertThat(concatenatedWords, is(not(empty())));
    }


}