package io;

import java.util.Scanner;

public class ConsoleInput extends Input{
    @Override
    protected double[][] readInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество пар (x,y). Должно быть не менее 12 пар");
        int n = input.nextInt();
        if(n<12)
            return null;
        double[][] data = new double[n][2];
        System.out.println("Введите пары (x,y) по одной паре в строке");
        for (int i = 0; i < n; i++) {
            System.out.println("x y");
            double x = input.nextDouble();
            double y = input.nextDouble();
            data[i][0] = x;
            data[i][1] = y;
        }
        return data;
    }
}
