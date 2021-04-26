package aed.tp4;

import java.util.*;

class generateInput {
    int[] array;
    Random rand;
    int max_int = 10000;

    public generateInput() {
        this.rand = new Random();
    }

    //Array random
    public int[] random(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(this.max_int);
        }
        return array;
    }

    //Array sorted descending
    public int[] decrescente(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }

    //Array with 5% of elements not sorted
    public int[] ordenado5Random(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        for (int i = 0; i < (int) (size * 0.05); i++) {
            array[rand.nextInt(size)] = rand.nextInt(this.max_int);
        }

        return array;
    }

    //Array with 1% of elements not sorted
    public int[] ordenado1Random(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        for (int i = 0; i < (int) (size * 0.01); i++) {
            array[rand.nextInt(size)] = rand.nextInt(this.max_int);
        }

        return array;
    }

}