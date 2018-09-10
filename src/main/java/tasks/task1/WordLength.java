package tasks.task1;

public class WordLength implements Comparable<WordLength> {


    int length;//Length of the word
    int frequncy;//word frequency in the string

    public WordLength(int length) {
        this.length = length;
        this.frequncy = 1;
    }

    public WordLength(int length, int frequncy) {
        this.length = length;
        this.frequncy = frequncy;
    }

    public void increaseFrequency() {
        frequncy++;
    }


    public int compareTo(int anotherLength) {
        if (this.length == anotherLength) return 0;
        else return this.length < anotherLength ? -1 : 1;
    }

    public int compareTo(WordLength wordLength) {
        if (this.length == wordLength.length)
            return 0;
        else return this.length < wordLength.length ? -1 : 1;
    }
}