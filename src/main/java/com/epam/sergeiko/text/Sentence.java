package com.epam.sergeiko.text;

import java.util.*;

public class Sentence implements Iterable<SenObject>{
    private List<SenObject> symbols = new ArrayList<>();
    public Sentence(){

    }
    public void addSymbol(SenObject symbol){
        this.symbols.add(symbol);
    }
    public void read (Scanner scanner) {
        String temp = null;
        boolean endOfSentence = false;
        int wordLength = 0;
        Stack marks = new Stack();

        do {
            if (!scanner.hasNext()) {
                endOfSentence = true;
            } else {
                temp = scanner.next();
                wordLength = temp.length();
                marks.push(PunctuationMark.create(temp.charAt(wordLength - 1)));
                if (marks.peek() == null) {
                    marks.pop();
                    this.addSymbol(new Word(temp));
                } else {
                    --wordLength;
                    if (((PunctuationMark) marks.peek()).isEndOfSentence()) {
                        endOfSentence = true;
                    }
                    for (int i = wordLength - 1; i >= 0; --i) {
                        marks.push(PunctuationMark.create(temp.charAt(i)));
                        if (marks.peek() == null) {
                            marks.pop();
                            break;
                        }
                        --wordLength;
                    }
                    if (wordLength > 0) {
                        this.addSymbol(new Word(temp.substring(0, wordLength)));
                    }
                    while (!marks.empty()) {
                        this.addSymbol((SenObject) marks.pop());
                    }
                }
            }
        } while (!endOfSentence);
    }
    public Iterator<SenObject> iterator(){
        return this.symbols.iterator();

    }


}
