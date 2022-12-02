package aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

// Put the return type of the generator in Base<>
public class Year2022_Day02 extends Base<ArrayList<String>> {

    // The generator's role is to turn teh input file into something useable by part 1 and part 2.
    void generator() {
        // this must have the same type as the return type of this method
        this.processed = new ArrayList<>();
        // read it line by line
        // for this one we just want an arraylist of numbers
        this.processed.addAll(Arrays.asList(this.input.split("\n")));
    }

    HashMap<Character, Integer> handPoints = new HashMap<>();
    HashMap<Character, Integer> calc = new HashMap<>();

    void part1() {
        int total = 0;
        handPoints.put('X', 1);
        handPoints.put('Y', 2);
        handPoints.put('Z', 3);

        calc.put('X', 0); //rock
        calc.put('Y', 1); //paper
        calc.put('Z', 2); //scissors
        calc.put('A', 0); //rock
        calc.put('B', 1); //paper
        calc.put('C', 2); //scissors

        for (String line : this.processed) {

            char op = line.charAt(0);
            char me = line.charAt(2);
            int i = calc.get(me);
            int j = calc.get(op);
            total += handPoints.get(me);

            switch (i - j) {
                case 0 -> //draw
                        total += 3;
                case -2, 1 -> //win
                        total += 6;
            }

        }
        System.out.println(total);
    }

    void part2() {

        int total = 0;
        int idx;

        HashMap<Character, Character> map = new HashMap<>();
        map.put('A', 'X');
        map.put('B', 'Y');
        map.put('C', 'Z');

        ArrayList<Character> chars = new ArrayList<>();
        chars.add('A');
        chars.add('B');
        chars.add('C');

        for(String line : this.processed) {

            char op = line.charAt(0);
            char goal = line.charAt(2);
            char me = 0;
            idx = chars.indexOf(op);
            switch (handPoints.get(goal)) {
                case 1 -> { //x lose
                    if (idx == 0) {
                        me = 'Z';
                    } else {
                        me = map.get(chars.get(idx - 1));
                    }
                }
                case 2 -> { //y draw
                    me = map.get(chars.get(idx));
                    total += 3;
                }
                case 3 -> { //z win
                    if (idx + 1 == chars.size()) {
                        me = 'X';
                    } else {
                        me = map.get(chars.get(idx + 1));
                    }
                    total += 6;
                }
            }

            total += handPoints.get(me);

        }

        System.out.println(total);
    }
}
