package com_gmail_kr_malyar;

import java.io.*;

import static java.lang.System.out;

public class WorkWithFile {

    public static String loadFromFile(File file) throws IllegalArgumentExeption {
        if (file == null) {
            throw new IllegalArgumentExeption("File is null");
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String spase = "";
            for (; (spase = br.readLine()) != null; ) {
                sb.append(spase);
                sb.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String[] wordsFromText(String line) {
        String[] words = line.split(" .,\n!?]");
        return words;
    }

    public static boolean searchWords(String word, String text) {
        String[] wordsArray = wordsFromText(text);
        for (int i = 0; i < wordsArray.length; i++) {
            if (word.equalsIgnoreCase(wordsArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static void saveToFile(String text, File file) {
        if (file == null || text == null) {
            throw new IllegalArgumentException("File or text is null");
        }
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.print(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void comparisonFile(File fileOne, File fileTwo,
                                      File fileResult) throws IllegalArgumentExeption {
        if (fileOne == null || fileTwo == null || fileResult == null) {
            throw new IllegalArgumentExeption("Some file is nuul");
        }
        String first = loadFromFile(fileOne);
        String second = loadFromFile(fileTwo);
        StringBuilder sb = new StringBuilder();
        String[] wordsOne = wordsFromText(first);
        
        for (int i = 0; i < wordsOne.length; i++) {
            if (searchWords(wordsOne[i], second)) {
                sb.append(wordsOne[i] + ";");
            }
            saveToFile(sb.toString(), fileResult);
        }
    }
}
