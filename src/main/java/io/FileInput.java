package io;

import jdk.internal.util.xml.impl.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput extends Input {
    @Override
    protected double[][] readInput() {
        System.out.println("Введите имя файла");
        Scanner input = new Scanner(System.in);
        String filename = input.next().trim();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int n = 0;
            List<Pair> pairs = new ArrayList<>();
            while(true) {
                String line = reader.readLine();
                if(line==null)
                    break;
                line = line.trim();
                String[] numbers = line.split(" ");
                if (numbers.length > 2)
                    throw new IOException("Неверный формат файла");
                pairs.add(new Pair(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])));
                n++;
            }
            if(n<12)
                return null;
            double[][] data = new double[n][2];
            for (int i = 0; i < n; i++) {
                data[i][0] = pairs.get(i).a;
                data[i][1] = pairs.get(i).b;
            }
            return data;
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    private class Pair {
        private double a;
        private double b;

        private Pair(double a, double b) {
            this.a = a;
            this.b = b;
        }
    }
}
