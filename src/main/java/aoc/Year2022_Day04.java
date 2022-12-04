package aoc;

import java.util.ArrayList;
import java.util.Arrays;

public class Year2022_Day04 extends Base<ArrayList<String>> {

    void generator() {
        this.processed = new ArrayList<>();
        this.processed.addAll(Arrays.asList(this.input.split("\n")));
    }


    void part1() {

        int total = 0;

        for (String line : this.processed) {

            String[] s = line.split(",");

            int a1 = Integer.parseInt(s[0].split("-")[0]); //2
            int a2 = Integer.parseInt(s[0].split("-")[1]); //4
            int b1 = Integer.parseInt(s[1].split("-")[0]); //6
            int b2 = Integer.parseInt(s[1].split("-")[1]); //8

            if (a1 >= b1 && a2 <= b2) {
                System.out.println(line);
                total++;
            }
            else if (b1 >= a1 && b2 <= a2) {
                total++;
            }

        }

        System.out.println(total);
    }

    void part2() {

        int total = 0;

        for (String line : this.processed) {

            String[] s = line.split(",");

            int a1 = Integer.parseInt(s[0].split("-")[0]); //2
            int a2 = Integer.parseInt(s[0].split("-")[1]); //4
            int b1 = Integer.parseInt(s[1].split("-")[0]); //6
            int b2 = Integer.parseInt(s[1].split("-")[1]); //8

            if (a1 <= b2 && b1 <= a2) {
                total++;
            }


        }

        System.out.println(total);


    }
}
