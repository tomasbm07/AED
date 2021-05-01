package aed.tp4;

class radixSort{
    int[] array;
    countingSort CS;

    public radixSort(){
        CS = new countingSort();
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public float sort(){
        long start = System.nanoTime();
        sort_aux(this.array);
        long end = System.nanoTime();
        checkSort();
        return (float) ((end - start) / 1000000); // ms
    }

    private void sort_aux(int[] array){
        int max = getMaxNum(array);

        for (int i = 1; max / i > 0; i *= 10) {
            CS.sort(array, array.length, i);
        }
    }

    private int getMaxNum(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    private void checkSort() {
        for (int i = 0; i < this.array.length - 1; i++) {
            if (i != 0) {
                if (this.array[i] > this.array[i + 1]) {
                    System.out.println("Radix Sort gone Wrong!!!");
                    System.exit(-1);
                }
            }
        }
    }

}


class countingSort {

    public countingSort(){}

    public void sort(int[] array, int size, int place){
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            array[i] = output[i];

    }

}