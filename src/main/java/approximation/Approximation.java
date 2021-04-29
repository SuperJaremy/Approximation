package approximation;

import java.util.Arrays;

public abstract class Approximation {

    private final double S;

    private final double rms;

    private final double RSq;

    protected String approximation;

    public Approximation(double[] X, double[] Y, int n) {
        solve(X, Y, n);
        S = deviation(X,Y,n);
        rms = Math.sqrt(S/n);
        RSq = RSq(X,Y,n);
    }

    protected abstract void solve(double[] X, double[] Y, int n);

    public abstract double phi(double x);

    private double deviation(double[] X, double[] Y, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum+= Math.pow(phi(X[i])-Y[i],2);
        }
        return sum;
    }

    private double RSq(double[] X, double[] Y, int n){
        double sum1 = Arrays.stream(X).map(x->Math.pow(phi(x),2)).sum();
        double sum2 = Arrays.stream(X).map(this::phi).sum();
        return 1 - S/(sum1-Math.pow(sum2,2)/n);
    }

    public double getRms() {
        return rms;
    }

    public double getRSq() {
        return RSq;
    }

    @Override
    public String toString(){
        return approximation;
    }
}
