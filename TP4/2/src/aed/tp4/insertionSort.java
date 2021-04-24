package aed.tp4;

class insertionSort {
    int[] array;

    public insertionSort() {
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void sort() {
        int pointer, j;
        for (int i = 1; i < this.array.length; i++) {
            pointer = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > pointer) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = pointer;
        }

        print();
    }

    private void print() {
        for (int i : this.array) {
            System.out.println(i);
        }
    }

} //insertionSort