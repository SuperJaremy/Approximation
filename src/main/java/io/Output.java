package io;

import approximation.Approximation;

public abstract class Output {

    private final Approximation approximation;

    public Output(Approximation approximation){
        this.approximation = approximation;
    }

    public abstract void write();
}
