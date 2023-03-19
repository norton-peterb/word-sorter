package com.example.wordsorter;

import java.util.*;

public class WordSorterApplication implements Runnable {

    private final String[] arguments;

    public WordSorterApplication(String[] arguments) {
        this.arguments = arguments;
    }

    public static void main(String[] args) {
        WordSorterApplication application = new WordSorterApplication(args);
        application.run();
    }

    private List<String> processDuplicates(List<String> inputList) {
        Map<String,String> duplicationMap = new HashMap<>();
        inputList.forEach(
                input -> {
                    if(!duplicationMap.containsKey(input.toLowerCase())) {
                        duplicationMap.put(input.toLowerCase(),input);
                    }
                }
        );
        return new ArrayList<>(duplicationMap.values());
    }

    @Override
    public void run() {
        List<String> args = new ArrayList<>(List.of(arguments));
        args = processDuplicates(args);
        args.sort(String::compareToIgnoreCase);
        args.sort(Comparator.comparing(String::length));
        StringBuilder stringBuilder = new StringBuilder();
        args.forEach(
                arg -> {
                    if(!stringBuilder.toString().equals("")) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(arg);
                }
        );
        System.out.println(stringBuilder);
    }
}
