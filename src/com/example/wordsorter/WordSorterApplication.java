package com.example.wordsorter;

public class WordSorterApplication implements Runnable {

    private final String[] arguments;

    public WordSorterApplication(String[] arguments) {
        this.arguments = arguments;
    }

    public static void main(String[] args) {
        WordSorterApplication application = new WordSorterApplication(args);
        application.run();
    }

    @Override
    public void run() {

    }
}
