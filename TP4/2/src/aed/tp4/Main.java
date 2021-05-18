package aed.tp4;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int SIZE = 10000000;

    public static void main(String[] args) {
        List<Integer> N = new ArrayList<>();
        List<Float> tempos = new ArrayList<>();
        List<Float> tempos_aux;

        quickSort QS = new quickSort();
        generateInput generator = new generateInput();

        int num_reps = 5; // numero de vezes de execução para cada i -> calcular media
        for (int i = (int) (SIZE * 0.05); i <= SIZE; i += (int) (SIZE * 0.05)) {
            tempos_aux = new ArrayList<>();
            for (int x = 0; x < num_reps; x++) {
                //QS.setArray(generator.random(i));
                QS.setArray(generator.decrescente(i));
                //QS.setArray(generator.ordenado1Random(i));
                //QS.setArray(generator.ordenado5Random(i));

                tempos_aux.add(QS.sort());
            }
            N.add(i);
            float tempo = media(tempos_aux, num_reps);
            tempos.add(tempo);
            System.out.format("N = %d, T = %.1f ms\n", i, tempo);
        }

        writeFile(N, tempos);

    }

    public static float media(List<Float> tempos, int reps) {
        long sum = 0;
        for (float f : tempos) {
            sum += f;
        }
        return (float) ((double) sum / (double) reps);
    }

    public static void writeFile(List<Integer> N, List<Float> tempos) {
        try {
            FileWriter f = new FileWriter("results.csv");
            f.write("N,tempo(ms)\n");
            for (int i = 0; i < N.size(); i++) {
                f.write("%d,%f\n".formatted(N.get(i), tempos.get(i)));
            }
            f.close();
            Desktop.getDesktop().open(new File("results.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
