package com.epam.sergeiko.text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class Vocabulary {
    private TreeSet<Word> words = new TreeSet();

    public Vocabulary() {
    }
    public boolean addWord(Word word) {
        return this.words.add(word);
    }

    public void printToHTML(String filename) {
        BufferedWriter out = null;
        char currentLetter = ' ';
        boolean newLetter = false;
        String currentWord = null;

        try {
            out = new BufferedWriter(new FileWriter(filename));
            out.write("<html>");
            out.newLine();
            out.write("<body>");
            out.newLine();

            for(Iterator variant3 = this.words.iterator(); variant3.hasNext(); out.newLine()) {
                Word w = (Word)variant3.next();
                currentWord = w.getWord();
                if (Character.toLowerCase(currentWord.charAt(0)) != currentLetter) {
                    newLetter = true;
                    currentLetter = Character.toLowerCase(currentWord.charAt(0));
                    out.write("<font color=\"blue\">");
                }

                out.write(currentWord);
                out.write("<br/>");
                if (newLetter) {
                    newLetter = false;
                    out.write("</font>");
                }
            }

            out.write("</body>");
            out.newLine();
            out.write("</html>");
            out.newLine();
            out.close();
        } catch (IOException variant4) {
            System.out.println("Cannot write to the file " + filename);
        }
    }
    public void printMessage(){
        System.out.println("Check the result in result.htm");
    }

}

