package aed.tp4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ShellSort {
    ArrayList<Integer> array;

    public ShellSort() {}

    public ShellSort(ArrayList<Integer> array) {
        this.array = array;
    }

    public void setArray(ArrayList<Integer> array) {
        this.array = array;
    }

    private void shellSort(List<Integer> gaps){
        int temp;
        int i, j;

        for (int gap : gaps) {
            for (i = gap; i < this.array.size(); i++) {
                temp = this.array.get(i);
                for (j = i; j >= gap && this.array.get(j - gap) > temp; j -= gap) {
                    this.array.set(j, this.array.get(j - gap));
                }
                this.array.set(j, temp);
            }
        }
    }

    public long base_sort() {
        long final_time;

        //create gaps
        List<Integer> gaps = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            gaps.add((int) Math.pow(2, i));
        }

        long start_time = System.nanoTime();

        //shell sort algorithm
        shellSort(gaps);

        final_time = System.nanoTime() - start_time;
        return final_time / 1000000; //ms
    }

    public long improved_sort_1() {
        long final_time;

        //create gaps
        List<Integer> gaps = new ArrayList<>();
        for (int i = this.array.size()/2; i > 0; i /= 2) {
            gaps.add(i);
        }

        long start_time = System.nanoTime();

        shellSort(gaps);

        final_time = System.nanoTime() - start_time;
        return final_time / 1000000; //ms
    }

}