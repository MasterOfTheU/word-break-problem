package testing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;
import static wbpsolution.WordsHandler.*;


public class WordsHandlerTest {
    private Set<String> dictionary;

    @Before
    public void init() throws Exception {
        dictionary = getWordsFromFile("test.txt");
    }

    @Test
    public void testGetWordsFromFile() {
        assertThat(dictionary, is(not(empty())));
    }

    @Test
    public void testFindConcatenatedWords() {
        ArrayList<String> concatenatedWords = findConcatenatedWords(dictionary, new ArrayList<>());
        assertThat(concatenatedWords, is(not(empty())));
    }


}