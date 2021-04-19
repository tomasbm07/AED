package aed.tp4;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.*;

public class Main {
    private static final int SIZE = 10000000;

    public static void main(String[] args) {
        List<Integer> N = new ArrayList<>();
        List<Float> tempos = new ArrayList<>();

        ShellSort SS = new ShellSort();
        generateInput generator = new generateInput();

        float tempo;

        for (int i = (int) (SIZE * 0.05); i <= SIZE; i += (int) (SIZE * 0.05)) {
            SS.setArray(generator.random(i));
            //SS.setArray(generator.decrescente(i));
            //SS.setArray(generator.ordenado5Random(i));
            //SS.setArray(generator.ordenado1Random(i));

            tempo = SS.base_sort();
            //tempo = SS.improved_sort_1();
            //tempo = SS.improved_sort_2();
            //tempo = SS.improved_sort_3();
            //tempo = SS.improved_sort_4();

            tempo = tempo / 1000;
            N.add(i);
            tempos.add(tempo);
            System.out.format("N = %d, T = %.3f s\n", i, tempo);
        }

        try {
            FileWriter f = new FileWriter("results.csv");
            f.write("N,tempo(ms)\n");
            for (int i = 0; i < N.size(); i++) {
                f.write("%d,%.3f\n".formatted(N.get(i), tempos.get(i)));
            }
            f.close();
            Desktop.getDesktop().open(new File("results.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class generateInput {
    ArrayList<Integer> array;
    Random rand;
    int max_int = 10000;

    public generateInput() {
        this.rand = new Random();
    }

    //Array random
    public ArrayList<Integer> random(int size) {
        array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(rand.nextInt(this.max_int));
        }
        return array;
    }

    //Array sorted descending
    public ArrayList<Integer> decrescente(int size) {
        array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(i);
        }
        Collections.reverse(array);
        return array;
    }

    //Array with 5% of elements not sorted
    public ArrayList<Integer> ordenado5Random(int size) {
        array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(i);
        }

        for (int i = 0; i < (int) (size * 0.05); i++) {
            array.set(this.array.size(), this.max_int);
        }

        return array;
    }

    //Array with 1% of elements not sorted
    public ArrayList<Integer> ordenado1Random(int size) {
        array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(i);
        }

        for (int i = 0; i < (int) (size * 0.01); i++) {
            array.set(this.array.size(), this.max_int);
        }

        return array;
    }

}
