package aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Year2022_Day03 extends Base<ArrayList<String>> {

    void generator() {
        this.processed = new ArrayList<>();
        this.processed.addAll(Arrays.asList(this.input.split("\n")));
    }


    void part1() {

        int total = 0;
        //split strings in half
        //compare each character in each
        //if character is in both, convert to number
        //add to total

        for (String value : this.processed) {
            String a = value.substring(0, value.length() / 2);
            String b = value.substring(value.length()/2);

            for (String s : a.split("")) {
                if (b.contains(s)) {
                    if (s.equals(s.toLowerCase())) {
                        total += s.charAt(0) - 96;
                    } else {
                        total += s.charAt(0) - 38;
                    }
                    break;

                }
            }
        }
        System.out.println(total);
    }

    void part2() {

        int total = 0;

        for(int i = 0; i < this.processed.size();i+=3) {
            String a = this.processed.get(i);
            String b = this.processed.get(i + 1);
            String c = this.processed.get(i + 2);

            for (String s : a.split("")) {
                if (b.contains(s)) {
                    if (c.contains(s)) {
                        if (s.equals(s.toLowerCase())) {
                            total += s.charAt(0) - 96;
                        } else {
                            total += s.charAt(0) - 38;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(total);

    }
}
