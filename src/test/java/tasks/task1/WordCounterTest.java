package tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tasks.task1.WordCounter;
import tasks.task1.WordLength;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WordCounterTest {

    WordCounter wordCounter;

    @Before
    public void setUp() throws Exception {
        wordCounter = new WordCounter();
    }

    @After
    public void tearDown() throws Exception {
        wordCounter = null;
    }

    @Test
    public void countEachWord() {
        boolean check =  new WordCounter(Arrays.asList(
                new WordLength(2, 1),
                new WordLength(4, 2),
                new WordLength(5, 1),
                new WordLength(6, 2),
                new WordLength(7, 1),
                new WordLength(8, 2),
                new WordLength(9, 1))).compareTo(
                new WordCounter(wordCounter.countEachWord("Скажи-ка, дядя, ведь не даром Москва, спаленная пожаром, Французу отдана"))) == 0 ? true:false;

        assertEquals(true,check);
        assertEquals(null,wordCounter.countEachWord(null));
        assertEquals(null,wordCounter.countEachWord(""));

    }

    @Test
    public void printEachWord() {
        wordCounter.printEachWord(wordCounter.countEachWord("я достаю из широких штанин дубликатом бесценного груза"));
    }
}