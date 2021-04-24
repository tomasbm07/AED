package aed.tp4;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.*;

class quickSort {
    int[] array;

    public quickSort() {}

    public quickSort(int[] array) {
        this.array = array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public long sort() {
        long start = System.nanoTime();
        recursiveQuickSort(this.array, 0, this.array.length - 1);
        long end = System.nanoTime();
        //print();
        checkSort();
        return (end - start) / 1000000; // return execution time in ms
    }

    private void recursiveQuickSort(int[] array, int startIndex, int endIndex) {
        int index = partition(array, startIndex, endIndex);

        if (startIndex < index - 1) {
            recursiveQuickSort(array, startIndex, index - 1);
        }

        if (endIndex > index) {
            recursiveQuickSort(array, index, endIndex);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[left]; // considerar o 1º elemento como pivot
        //int pivot = array[right];
        //int pivot = array[(int)(array.length / 2)];

        while (left <= right) {
            //procurar num que é maior do que o pivot. esquerda -> direita (do array)
            while (array[left] < pivot) {
                left++;
            }
            //procurar num que é menor do que o pivot. direita -> esquerda (do array)
            while (array[right] > pivot) {
                right--;
            }
            //swap
            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int x, int y){
        int aux;
        aux = this.array[x];
        this.array[x] = this.array[y];
        this.array[y] = aux;
    }

    private void checkSort(){
        for (int i = 0; i < this.array.length - 1; i++) {
            if (i == 0){
            } else {
                if (this.array[i] > this.array[i+1]){
                    System.out.println("Quik Sort gone Wrong!!!");
                }
            }
        }
    }

    private void print(){
        for (int i : this.array) {
            System.out.println(i);
        }
    }

} // quickSort


class insertionSort {
    ArrayList<Integer> array;


    public insertionSort() {
    }

    public insertionSort(ArrayList<Integer> array) {
        this.array = array;
    }

    public void sort() {

    }


} //insertionSort