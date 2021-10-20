package com.epam.sergeiko.text;

public class PunctuationMark extends Symbol implements SenObject{
    private boolean endOfSentence;

    private PunctuationMark(char symbol) {
        super(symbol);
        if (symbol == '.' || symbol == '?' || symbol == '!') {
            this.endOfSentence = true;
        }

    }

    public static boolean isPunctuation(char symbol) {
        return (symbol < 'a' || symbol > 'z') && (symbol < 'A' || symbol > 'Z') && symbol != '\'';
    }

    public static PunctuationMark create(char symbol) {
        return isPunctuation(symbol) ? new PunctuationMark(symbol) : null;
    }

    public boolean isEndOfSentence() {
        return this.endOfSentence;
    }
}
