package io;

import approximation.Approximation;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileOutput extends Output{

    public FileOutput(Approximation approximation){
        super(approximation);
    }

    @Override
    public void write(List<String> strings) {
        System.out.println("Введите имя файла");
        Scanner input = new Scanner(System.in);
        String filename = input.next().trim();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for (String i:
                 strings) {
                writer.write(i);
            }
        }
        catch (IOException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
