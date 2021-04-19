package aed.tp4;

public class Main {
    private static final int SIZE = 1000000;

    public static void main(String[] args) {
        baseShellSort BSD = new baseShellSort();

        for (int i = 100000; i < SIZE; i += 100000) {
            System.out.println(BSD.sort(i));
        }


    }
}
