package aed.tp4;

class insertionSort {
    int[] array;

    public insertionSort() {
    }

    public void sort(int[] array, int start, int end) {
        int pointer, j;
        for (int i = start + 1; i <= end; i++) {
            pointer = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > pointer) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = pointer;
        }

        //print();
    }

    private void print() {
        for (int i : this.array) {
            System.out.println(i);
        }
    }

    private void checkSort() {
        for (int i = 0; i < array.length - 1; i++) {
            if (i != 0) {
                if (this.array[i] > this.array[i + 1]) {
                    System.out.println("Quik Sort gone Wrong!!!");
                    System.exit(-1);
                }
            }
        }
    }

} //insertionSort