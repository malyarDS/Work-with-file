package com_gmail_kr_malyar;

import java.io.File;

public class Main {
    public static void main(String[] args) throws IllegalArgumentExeption {
        WorkWithFile.comparisonFile(new File("fileOne.txt"), new File("fileTwo.txt"), new File("result.txt"));
    }
}
