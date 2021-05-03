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


class radixSortBase2 {
    int[] array;

    public radixSortBase2(){}

    public void setArray(int[] array) {
        this.array = array;
    }

    private int getBitValue(int number, int bit){
        int mask = 1 << bit;
        if ((number & mask) != 0 )
            return 1;

        return  0;
    }

    private int[] countingSort(int[] array, int bit){
        int[] count = new int[]{0,0};
        int[] sortedArray = new int[array.length];
        int itemBitValue;

        for (int i : array) {
            count[getBitValue(i, bit)] += 1;
        }

        int[] index = new int[]{0, count[0]};

        for (int i : array) {
            itemBitValue = getBitValue(i, bit);
            sortedArray[index[itemBitValue]] = i;
            index[itemBitValue] += 1;
        }
        return sortedArray;
    }

    private void aux_sort(int num_bits){
        for (int i = 0; i < num_bits; i++) {
            this.array = countingSort(this.array, i);
        }
    }

    public float sort(){
        long start = System.nanoTime();
        aux_sort(countBits(getMaxNum()));
        long end = System.nanoTime();
        checkSort(); // make sure array is sorted
        return (float) ((end - start) / 1000000); // ms
    }

    private int getMaxNum(){
        int max = this.array[0];
        for (int i = 1; i < this.array.length; i++) {
            if (this.array[i] > max)
                max = this.array[i];
        }
        return max;
    }

    private int countBits(int num){
        return (int)(Math.log(num) / Math.log(2) +1);
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