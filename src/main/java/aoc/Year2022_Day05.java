package aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Year2022_Day05 extends Base<ArrayList<String>> {


    void generator() {
        this.processed = new ArrayList<>();
        this.processed.addAll(Arrays.asList(this.input.split("\n")));
    }


    void part1() {

        ArrayList<ArrayList<Character>> array = new ArrayList<>();
        int nums = 0;
        int instructions = 0;

        for (int i = 0; i < this.processed.size(); i++) {
            if (this.processed.get(i).contains(" 1  ")) {
                nums = i;
            }
            if (this.processed.get(i).contains("move")) {
                instructions = i;
                break;
            }
        }

        for (int col = 1; col <= this.processed.get(nums - 1).length(); col += 4) {
            ArrayList<Character> temp = new ArrayList<>();
            for (int row = nums - 1; row >= 0; row--) {
                if (this.processed.get(row).length() >= col) {
                    if (this.processed.get(row).charAt(col) != ' ') {
                        char a = this.processed.get(row).charAt(col);
                        temp.add(a);
                    }
                }
            }
            array.add(temp);
        }

        System.out.println();

        for (int i = instructions; i < this.processed.size(); i++) {
            //for (int i = instructions; i < instructions+2; i++) {

            String[] s = this.processed.get(i).split(" ");
            int amount = Integer.parseInt(s[1]);
            int from = Integer.parseInt(s[3]) - 1;
            int to = Integer.parseInt(s[5]) - 1;

            ArrayList<Character> chars = new ArrayList<>();
            ArrayList<Character> fullArray = array.get(from);

            for (int j = fullArray.size() - amount; j < fullArray.size(); j++) {
                chars.add(fullArray.get(j));
            }

            //flip chars
            ArrayList<Character> temp = new ArrayList<>();
            for (int k = chars.size() - 1; k >= 0; k--) {
                temp.add(chars.get(k));
            }

            int p = 0;
            while (p < chars.size()) {
                fullArray.remove(fullArray.size() - 1);
                p++;
            }
            array.set(from, fullArray);
            array.get(to).addAll(temp);
        }

        StringBuilder sb = new StringBuilder();
        for (ArrayList<Character> c : array) {
            sb.append(c.get(c.size() - 1));
        }

        //System.out.println(string(array));
        System.out.println(sb);

    }

    void part2() {

        ArrayList<ArrayList<Character>> array = new ArrayList<>();
        int nums = 0;
        int instructions = 0;

        for (int i = 0; i < this.processed.size(); i++) {
            if (this.processed.get(i).contains(" 1  ")) {
                nums = i;
            }
            if (this.processed.get(i).contains("move")) {
                instructions = i;
                break;
            }
        }

        for (int col = 1; col <= this.processed.get(nums - 1).length(); col += 4) {
            ArrayList<Character> temp = new ArrayList<>();
            for (int row = nums - 1; row >= 0; row--) {
                if (this.processed.get(row).length() >= col) {
                    if (this.processed.get(row).charAt(col) != ' ') {
                        char a = this.processed.get(row).charAt(col);
                        temp.add(a);
                    }
                }
            }
            array.add(temp);
        }

        System.out.println();

        for (int i = instructions; i < this.processed.size(); i++) {
            //for (int i = instructions; i < instructions+2; i++) {

            String[] s = this.processed.get(i).split(" ");
            int amount = Integer.parseInt(s[1]);
            int from = Integer.parseInt(s[3]) - 1;
            int to = Integer.parseInt(s[5]) - 1;

            ArrayList<Character> chars = new ArrayList<>();
            ArrayList<Character> fullArray = array.get(from);

            for (int j = fullArray.size() - amount; j < fullArray.size(); j++) {
                chars.add(fullArray.get(j));
            }

            //flip chars
//            ArrayList<Character> temp = new ArrayList<>();
//            for(int k = chars.size()-1; k >= 0; k--) {
//                temp.add(chars.get(k));
//            }

            int p = 0;
            while (p < chars.size()) {
                fullArray.remove(fullArray.size() - 1);
                p++;
            }
            array.set(from, fullArray);
            array.get(to).addAll(chars);
        }

        StringBuilder sb = new StringBuilder();
        for (ArrayList<Character> c : array) {
            sb.append(c.get(c.size() - 1));
        }

        //System.out.println(string(array));
        System.out.println(sb);

    }





    public String string(ArrayList<ArrayList<Character>> list) {

        StringBuilder sb = new StringBuilder();
        for (ArrayList<Character> l : list) {
            for (char s : l) {
                sb.append(s);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
