package aed.tp4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class baseShellSort {
    List<Integer> array;

    public baseShellSort() {}

    private void generateArray(int size){
        Random r = new Random();
        this.array = new ArrayList<>();
        for (int i = 0; i < size; i++){
            this.array.add(r.nextInt(10000));
        }
    }

    public long sort(int size) {
        long final_time;
        int temp;
        int i, j;

        generateArray(size);

        long start_time = System.nanoTime();

        List<Integer> gaps = new ArrayList<>();
        for (i = 0; i < 10; i++){
            gaps.add((int) Math.pow(2, i));
        }

        for (int gap : gaps) {
            for (i = gap; i < array.size(); i++) {
                temp = array.get(i);
                for (j = i; j >= gap && array.get(j - gap) > temp; j -= gap) {
                    array.set(j, array.get(j - gap));
                }
                array.set(j, temp);
            }
        }

        final_time = System.nanoTime() - start_time;
        return final_time / 1000000*1000; //ms*1000 = s
    }

}