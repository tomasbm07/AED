package aed.tp3;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> N = new ArrayList<>();
        List<Long> tempos = new ArrayList<>();

        String consulta, clientes;

        ArrayList<String> nomes = new ArrayList<>();
        Tree tree = new Tree();

        clientes = generateClientes(5000, nomes);
        //adicionar clientes á arovre

        long start_time;
        for (int i = 200000; i <= 4000000; i += 200000) {
            tree.reset();
            //inserir clientes
            String[] lines = clientes.split("\n");
            String[] aux;
            for (String a : lines) {
                aux = a.split(" ");
                tree.insert(new Cliente(aux[2] + " " + aux[3], aux[1], Integer.parseInt(aux[4])));
            }

            N.add(i);
            consulta = generateConsulta(i, nomes);
            lines = consulta.split("\n");

            start_time = System.nanoTime();
            for (String a : lines) {
                if (a.equals("FIM")) {
                    //System.out.println("Done");
                    break;
                }
                aux = a.split(" ");

                tree.search(aux[1]);
            }
            long total_time = System.nanoTime() - start_time;
            tempos.add(total_time / 1000000);
        }

        try {
            FileWriter f = new FileWriter("results.csv");
            f.write("N,tempo(ms)\n");
            for (int i = 0; i < N.size(); i++) {
                f.write("%d,%d\n".formatted(N.get(i), tempos.get(i)));
            }

            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String generateConsulta(int size, ArrayList<String> nomes) {
        Random rand = new Random();
        StringBuilder aux = new StringBuilder();
        List<String> nomes_aux = new ArrayList<>();
        /*
        //get 5% dos nomes
        for (int i = 0; i < (int) (5000 * 0.05); i++) {
            nomes_aux.add(nomes.get(i));
        }
        //criar sting de consulta em que 90% das consultas sao a 5% dos clientes
        for (int i = 0; i < (int) (size*0.9); i++) {
            aux.append("CONSULTA ").append(nomes_aux.get(rand.nextInt(nomes_aux.size()))).append("\n");
        }
        for (int i = 0; i < (int) (size*0.1); i++) {
            aux.append("CONSULTA ").append(nomes.get(rand.nextInt(nomes.size()))).append("\n");
        }
        aux.append("FIM");

         */


        //criar sting de consulta em que todos os clientes tem a mesma chance de serem consultados
        for (int i = 0; i < size; i++) {
            aux.append("CONSULTA ").append(nomes.get(rand.nextInt(nomes.size()))).append("\n");
        }
        aux.append("FIM");

        return aux.toString();
    }

    private static String generateClientes(int size, ArrayList<String> nomes) {
        Random rand = new Random();
        StringBuilder aux = new StringBuilder();
        for (int i = 0; i < size; i++) {
            aux.append("CLIENTE ").append(randomName(nomes)).append(" Rua OMEGALUL ").append(rand.nextInt(200)).append("\n");
        }
        return aux.toString();
    }

    private static String randomName(ArrayList<String> nomes) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 10;

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        nomes.add(sb.toString());
        return sb.toString();
    }
}
