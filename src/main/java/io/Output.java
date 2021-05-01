package io;

import approximation.Approximation;
import approximation.Linear;

import java.util.ArrayList;
import java.util.List;

public abstract class Output {

    protected List<String> strings;

    public Output(List<Approximation> approximations) {
        strings = new ArrayList<>();
        for (Approximation approximation : approximations) {
            strings.add(String.format("Аппроксимирующая функция: %s", approximation));
            strings.add(String.format("Тип: %s",approximation.getType()));
            strings.add(String.format("R^2: %f", approximation.getRSq()));
            strings.add(String.format("SD: %f", approximation.getSD()));
            try {
                Linear linear = (Linear) approximation;
                strings.add(String.format("Коэффициент Пирсона: %f", linear.getCorrelation()));
            } catch (ClassCastException ignored) {
            }
            finally {
                strings.add("\n");
            }
        }
    }

    public final void write(){
        write(strings);
    }

    protected abstract void write(List<String> strings);
}
