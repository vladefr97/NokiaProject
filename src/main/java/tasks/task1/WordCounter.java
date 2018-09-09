package tasks.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordCounter implements Comparable<WordCounter> {
    List<WordLength> wordCounts;

    public WordCounter() {
    }

    public WordCounter(List<WordLength> wordCounts) {
        this.wordCounts = wordCounts;
    }



    public static void main(String[] args) {

        WordCounter wordCounter = new WordCounter();

        wordCounter.printEachWord(wordCounter.countEachWord("Скажи-ка, дядя, ведь не даром Москва, спаленная пожаром, Французу отдана"));

    }

    public List<WordLength> countEachWord(String string) {

        if (string == null || string.equals(""))
            return null;

        wordCounts = new ArrayList<WordLength>();
        String[] array = string.trim().split("\\p{P}?[ \\t\\n\\r]+");


        wordCounts.add(new WordLength(array[0].length()));

        for (int i = 1; i < array.length; i++) {
            int len = array[i].length();

            int size = wordCounts.size();
            Boolean check = true;
            for (int j = 0; j < size; j++) {
                WordLength temp = wordCounts.get(j);
                if (temp.compareTo(array[i].length()) == 0) {
                    temp.increaseFrequency();
                    check = false;
                    break;
                }
            }
            if (check)
                wordCounts.add(new WordLength(array[i].length()));

        }

        wordCounts.sort(Comparator.naturalOrder());
        return wordCounts;
    }

    public void printEachWord(List<WordLength> wordLengths) {
        if (wordLengths == null)
            return;

        for (WordLength el : wordLengths)
            System.out.println(el.frequncy + " words of " + el.length + " letter");

    }


    @Override
    public int compareTo(WordCounter wordCounter) {

        if (this.wordCounts.size() != wordCounter.wordCounts.size())
            return this.wordCounts.size() > wordCounter.wordCounts.size() ? 1 : -1;

        int size = wordCounts.size();

        for (int i = 0; i < size; i++) {
            int compr = this.wordCounts.get(i).compareTo(wordCounter.wordCounts.get(i));
            if (compr != 0)
                return compr;
        }

        return 0;


    }

}
