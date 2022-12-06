package aoc;

import java.util.*;

public class Year2022_Day06 extends Base<ArrayList<String>> {

    void generator() {
        this.input = this.input.replace("\n", "");
    }

    void part1() {

        int counter = 0;
        ArrayList<Character> list = new ArrayList<>();

        for(int i = 0; i <  this.input.length(); i++) {
            char c = this.input.charAt(i);

            if(list.contains(c)) {
                int idx = list.indexOf(c);
                list = new ArrayList<>(list.subList(idx+1, list.size()));
                list.add(c);
            }
            else {
                list.add(c);
            }
            if(list.size() == 4) {
                break;
            }
            counter++;

        }
        System.out.println(counter+1);
    }

    void part2() {

        int counter = 0;
        ArrayList<Character> list = new ArrayList<>();

        for(int i = 0; i <  this.input.length(); i++) {
            char c = this.input.charAt(i);

            if(list.contains(c)) {
                int idx = list.indexOf(c);
                list = new ArrayList<>(list.subList(idx+1, list.size()));
                list.add(c);
            }
            else {
                list.add(c);
            }
            if(list.size() == 14) {
                break;
            }
            counter++;

        }
        System.out.println(counter+1);
    }

}
