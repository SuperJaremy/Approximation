package approximation;

import java.util.Arrays;

public class Linear extends HiddenLinear {

    private final double r;

    public Linear(double[] X, double[] Y, int n) {
        super(X, Y, n);
        r = correlation(X, Y, n);
        approximation = String.format("%f*x+%f", a, b);
    }

    private double correlation(double[] X, double[] Y, int n) {
        double avgX = Arrays.stream(X).average().getAsDouble();
        double avgY = Arrays.stream(Y).average().getAsDouble();
        double upper = 0;
        for (int i = 0; i < n; i++) {
            upper += (X[i] - avgX) * (Y[i] - avgY);
        }
        double lower = Math.sqrt(Arrays.stream(X).
                map(x -> Math.pow(x - avgX, 2)).sum()
                * Arrays.stream(Y).map(y -> Math.pow(y - avgY, 2)).sum());
        return upper / lower;
    }

    @Override
    public double phi(double x) {
        return a * x + b;
    }

    public double getCorrelation() {
        return r;
    }
}
