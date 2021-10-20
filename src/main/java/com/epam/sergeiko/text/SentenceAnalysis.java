package com.epam.sergeiko.text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SentenceAnalysis {
        private Vocabulary vocabulary = new Vocabulary();
        private List<Sentence> text = new ArrayList();

        public SentenceAnalysis() {
        }

        public void parse(Scanner scanner) {
            Sentence temp = null;

            while(scanner.hasNext()) {
                temp = new Sentence();
                temp.read(scanner);
                this.text.add(temp);
            }

        }

        public Vocabulary createVocabulary() {
            Iterator variant1 = this.text.iterator();

            while(variant1.hasNext()) {
                Sentence s = (Sentence)variant1.next();
                Iterator variant2 = s.iterator();

                while(variant2.hasNext()) {
                    SenObject symbol = (SenObject)variant2.next();
                    if (symbol instanceof Word) {
                        this.vocabulary.addWord((Word)symbol);
                    }
                }
            }

            return this.vocabulary;
        }

        public Vocabulary getVocabulary() {
            return this.vocabulary;
        }

        public static void main(String[] args) {
            SentenceAnalysis analysis = new SentenceAnalysis();

            try {
                analysis.parse(new Scanner(new File("book.txt")));
            } catch (FileNotFoundException variant3) {
                System.out.println("Cannot open book.txt");
            }

            analysis.createVocabulary().printToHTML("result.htm");
            analysis.createVocabulary().printMessage();
        }
}
