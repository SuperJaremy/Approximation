package io;

import approximation.Approximation;

import java.util.ArrayList;
import java.util.List;

public abstract class Output {

    protected final Approximation approximation;
    protected List<String> strings;

    public Output(Approximation approximation){
        this.approximation = approximation;
        strings = new ArrayList<>();
        strings.add(String.format("Лучшая аппроксимирующая функция: %s", approximation));
        strings.add(String.format("R^2: %f",approximation.getRSq()));
    }

    public final void write(){
        write(strings);
    }

    protected abstract void write(List<String> strings);
}
