package aoc;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Year2022_Day08 extends Base<ArrayList<String>> {


    void generator() {
        this.processed = new ArrayList<>();
        this.processed.addAll(Arrays.asList(this.input.split("\n")));

    }


    void part1() {

        int counter = 0;


        //go through left to right
        for (int i = 0; i < this.processed.size(); i++) {
            for (int j = 0; j < this.processed.get(i).length(); j++) {
                if (checker(this.processed, i, j)) {
                    counter++;
                }

            }
        }
        System.out.println(counter);
    }

    void part2() {

        int counter = 0;


        //go through left to right
        for (int i = 0; i < this.processed.size(); i++) {
            for (int j = 0; j < this.processed.get(i).length(); j++) {
                if (score(this.processed, i, j) > counter) {
                    counter = score(this.processed, i, j);
                }

            }
        }
        System.out.println(counter);
    }


    public String toString(String[][] array) {
        StringBuilder sb = new StringBuilder();
        for (String[] ar : array) {
            sb.append(Arrays.toString(ar)).append("\n");
        }
        return sb.toString();
    }

    public int score(ArrayList<String> array, int row, int col) {
        int num = Character.getNumericValue(array.get(row).charAt(col));
        int score = 0;
        int temp = 0;

        for (int j = row + 1; j < array.size(); j++) {
            if (row == array.size()) {break;}
            score++;
            if (Character.getNumericValue(array.get(j).charAt(col)) >= num) {
                break;
            }
        }


        for (int j = row - 1; j >= 0; j--) {
            if (row == 0) {break;}
            temp++;
            if (Character.getNumericValue(array.get(j).charAt(col)) >= num) {
                break;
            }
        }
        score = score * temp;
        temp = 0;


        for (int j = col + 1; j < array.get(0).length(); j++) {
            if (col == array.get(0).length()) {break;}
            temp++;
            if (Character.getNumericValue(array.get(row).charAt(j)) >= num) {
                break;
            }
        }
        score = score * temp;
        temp = 0;


        for (int j = col - 1; j >= 0; j--) {
            if (col == 0) {break;}
            temp++;
            if (Character.getNumericValue(array.get(row).charAt(j)) >= num) {
                break;
            }
        }
        score = score * temp;
        return score;
    }
    public boolean checker(ArrayList<String> array, int row, int col) {

        int num = Character.getNumericValue(array.get(row).charAt(col));
        boolean bool = true;

        for (int j = row + 1; j < array.size(); j++) {
            if (Character.getNumericValue(array.get(j).charAt(col)) >= num) {
                bool = false;
                break;
            }
        }
        if (bool) {
            return true;
        }
        bool = true;

        for (int j = row - 1; j >= 0; j--) {
            if (Character.getNumericValue(array.get(j).charAt(col)) >= num) {
                bool = false;
                break;
            }
        }
        if (bool) {
            return true;
        }
        bool = true;

        for (int j = col + 1; j < array.get(0).length(); j++) {
            if (Character.getNumericValue(array.get(row).charAt(j)) >= num) {
                bool = false;
                break;
            }
        }
        if (bool) {
            return true;
        }
        bool = true;

        for (int j = col - 1; j >= 0; j--) {
            if (Character.getNumericValue(array.get(row).charAt(j)) >= num) {
                bool = false;
                break;
            }
        }

        return bool;
    }

}
