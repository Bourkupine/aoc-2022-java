package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


abstract public class Base<T> {
    private String className;
    String input;
    T processed;

    void run(){
        this.className = this.getClass().getSimpleName();
        System.out.println(this.className);

        getInput();
        generator();
        part1();
        part2();

        System.out.println();
    }

    /**
     * Standard format to read the input from file
     */
    void getInput() {
        String path = String.format("./input/%s.txt", this.className);

        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String sCurrentLine;
            while ((sCurrentLine = reader.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.input = contentBuilder.toString();
    }

    /**
     * This method is to convert the input into something usable b y part 1 and 2.
     */
    abstract void generator();

    /**
     * You start off the day with a single
     */
    abstract void part1();

    /**
     * Every day has a part 2 that extends the first part.
     */
    abstract void part2();
}
