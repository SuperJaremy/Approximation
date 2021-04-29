package io;

import approximation.Approximation;

import java.util.List;

public class ConsoleOutput extends Output{
    public ConsoleOutput(Approximation approximation){
        super(approximation);
    }

    @Override
    protected void write(List<String> strings) {
        for (String i:
             strings) {
            System.out.println(i);
        }
    }
}
