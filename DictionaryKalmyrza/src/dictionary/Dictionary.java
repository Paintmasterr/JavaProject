package dictionary;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

    private ArrayList<String[]> dictionary;
    private File file;

    public Dictionary() {
        this.dictionary = new ArrayList<>();
    }

    public Dictionary(String fileName) {
        this.dictionary = new ArrayList<>();
        this.file = new File(fileName);
    }

    public boolean load() {
        try {

            Scanner fileReader = new Scanner(Paths.get(this.file.getName()));

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
            return true;


        } catch (Exception e) {
            System.out.println("File load error: " + e.getMessage());
            return false;
        }
    }

    public boolean save() {
        try {
            PrintWriter pw = new PrintWriter(this.file.getName());
            for (String[] s : this.dictionary) {
                String word = s[0];
                String translation = s[1];
                pw.println(word + ":" + translation);
            }

            pw.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public void add(String words, String translation) {
        //splits the words into a string array
        String[] wordPair = new String[2];
        wordPair[0] = words;
        wordPair[1] = translation;
        this.dictionary.add(wordPair);
    }

    public String translate(String word) {
        for (String[] s : this.dictionary) {
            if (s[0].equals(word)) {
                return s[1];
            }
            if (s[1].equals(word)) {
                return s[0];
            }
        }
        return null;
    }

    public void delete(String word) {
        for (int i = 0; i < this.dictionary.size(); i++) {
            if (this.dictionary.get(i)[0].equals(word) || this.dictionary.get(i)[1].equals(word)) {
                this.dictionary.remove(i);
            }
        }
    }

}