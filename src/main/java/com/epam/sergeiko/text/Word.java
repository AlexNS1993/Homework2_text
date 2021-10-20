package com.epam.sergeiko.text;

public class Word implements Comparable<Word>, SenObject{
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return this.word;
    }

    public int compareTo(Word anotherWord) {
        return this.word.compareToIgnoreCase(anotherWord.getWord());
    }
}
