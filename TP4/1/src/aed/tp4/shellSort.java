package aed.tp4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class ShellSort {
    int[] array;

    public ShellSort() {}


    public void setArray(int[] array) {
        this.array = array;
    }

    private void shellSort(List<Integer> gaps) {
        int temp;
        int i, j;

        for (int gap : gaps) {
            for (i = gap; i < this.array.length; i++) {
                temp = this.array[i];
                for (j = i; j >= gap && this.array[j - gap] > temp; j -= gap) {
                    this.array[j] = this.array[j - gap];
                }
                this.array[j] = temp;
            }
        }
    }

    public long base_sort() {
        long final_time;

        //create gaps
        List<Integer> gaps = new ArrayList<>();
        for (int i = (int) (Math.log(this.array.length) / Math.log(2)); i >= 0; i--) {
            gaps.add((int) Math.pow(2, i));
        }
        //System.out.println(gaps);
        long start_time = System.nanoTime();

        //shell sort algorithm
        shellSort(gaps);

        final_time = System.nanoTime() - start_time;
        //System.out.println(array);
        return final_time / 1000000; //ms
    }

    /*
    public float improved_sort_1() {
        long final_time;

        //create gaps
        List<Integer> gaps = new ArrayList<>();
        for (int i = (int) (this.array.size() / 2); i > 0; i /= 2) {
            gaps.add(i);
        }

        long start_time = System.nanoTime();

        shellSort(gaps);

        final_time = System.nanoTime() - start_time;
        return (float) (final_time / 1000000); //ms
    }

    //lista de gaps: https://oeis.org/A033622
    public float improved_sort_2() {
        long final_time;

        int[] aux = {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001,
                36289, 64769, 146305, 260609, 587521, 1045505, 2354689,
                4188161, 9427969, 16764929, 37730305, 67084289,
                150958081, 268386305, 603906049, 1073643521};

        List<Integer> gaps = new ArrayList<>();
        for (int x : aux) {
            gaps.add(x);
        }
        Collections.reverse(gaps);

        long start_time = System.nanoTime();

        shellSort(gaps);

        final_time = System.nanoTime() - start_time;
        return (float) (final_time / 1000000); //ms
    }
     */

    //lista de gaps: https://oeis.org/A108870 - Tokuda's gaps
    public float improved_sort_3() {
        long final_time;

        //create gaps
        int[] aux = {1, 4, 9, 20, 46, 103, 233, 525, 1182, 2660, 5985, 13467,
                30301, 68178, 153401, 345152, 776591, 1747331, 3931496,
                8845866, 19903198, 44782196, 100759940, 226709866,
                510097200, 1147718700};

        List<Integer> gaps = new ArrayList<>();
        for (int x : aux) {
            gaps.add(x);
        }
        Collections.reverse(gaps);

        long start_time = System.nanoTime();

        shellSort(gaps);

        final_time = System.nanoTime() - start_time;
        return (float) (final_time / (double)1000000); //ms
    }
    /*
    //lista de gaps: https://oeis.org/A000225
    public float improved_sort_4() {
        long final_time;

        //create gaps
        int[] aux = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191,
                16383, 32767, 65535, 131071, 262143, 524287, 1048575,
                2097151, 4194303, 8388607, 16777215, 33554431,
                67108863, 134217727, 268435455, 536870911, 1073741823,
                2147483647};

        List<Integer> gaps = new ArrayList<>();
        for (int x : aux) {
            gaps.add(x);
        }
        Collections.reverse(gaps);

        long start_time = System.nanoTime();

        shellSort(gaps);

        final_time = System.nanoTime() - start_time;
        return (float) (final_time / 1000000); //ms
    }

     */

    private void checkSort() {
        for (int i = 0; i < this.array.length - 1; i++) {
            if (i != 0) {
                if (this.array[i] > this.array[i + 1]) {
                    System.out.println("Quik Sort gone Wrong!!!");
                    System.exit(-1);
                }
            }
        }
    }

}