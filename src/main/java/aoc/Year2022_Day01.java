package aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Put the return type of the generator in Base<>
public class Year2022_Day01 extends Base<ArrayList<String>> {

    // The generator's role is to turn teh input file into something useable by part 1 and part 2.
    void generator() {
        // this must have the same type as the return type of this method
        this.processed = new ArrayList<>();
        // read it line by line
        // for this one we just want an arraylist of numbers
        this.processed.addAll(Arrays.asList(this.input.split("\n")));
    }
        ArrayList<Integer> arr = new ArrayList<>();

    void part1() {

        arr.add(Integer.parseInt(this.processed.get(0)));
        int j = 0;

        for(int i = 1; i < this.processed.size(); i++) {

            String line = this.processed.get(i);

            if (this.processed.get(i-1).isEmpty()) {
                arr.add(Integer.parseInt(line));
            }

            else if(!line.isEmpty()) {
                arr.add(arr.get(j) + Integer.parseInt(line));
                arr.remove(j);
            }
            else {
                j++;
            }


        }
        Collections.sort(arr);
        System.out.println(arr.get(arr.size()-1));
    }

    void part2() {

        int total = 0;

        for(int i = 0; i<3; i++) {
            total += arr.get(arr.size()-1-i);
        }

        System.out.println(total);
    }
}
