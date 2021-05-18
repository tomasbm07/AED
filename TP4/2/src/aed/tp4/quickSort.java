package aed.tp4;


class quickSort {
    int[] array;
    insertionSort IS;
    //boolean doInsertionSort = false;
    boolean doInsertionSort = true;

    public quickSort() {
        IS = new insertionSort();
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public float sort() {
        long start = System.nanoTime();
        recursiveQuickSort(this.array, 0, this.array.length - 1);
        long end = System.nanoTime();
        checkSort();
        return (float) ((end - start) / 1000000); // return execution time in ms
    }

    private void recursiveQuickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex + 100 > endIndex && doInsertionSort) {
            IS.sort(array, startIndex, endIndex);
            //System.out.println("Doing Insertion Sort!");
        } else {
            int index = partition(array, startIndex, endIndex);

            if (startIndex < index - 1) {
                recursiveQuickSort(array, startIndex, index - 1);
            }

            if (endIndex > index) {
                recursiveQuickSort(array, index, endIndex);
            }
        }

    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[left + (right - left) / 2]; //conseiderar um elemento do meio do array como pivot

        while (left <= right) {
            //procurar num que é maior do que o pivot. esquerda -> direita (do array)
            while (array[left] < pivot) {
                left++;
            }
            //procurar num que é menor do que o pivot. direita -> esquerda (do array)
            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(left, right);
                //move pointers
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int x, int y) {
        int aux;
        aux = this.array[x];
        this.array[x] = this.array[y];
        this.array[y] = aux;
    }

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

    private void print() {
        for (int i : this.array) {
            System.out.println(i);
        }
    }

} // quickSort
