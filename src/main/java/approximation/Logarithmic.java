package approximation;


public class Logarithmic extends HiddenLinear {

    public Logarithmic(double[] X, double[] Y, int n) {
        super(X, Y, n);
        type = "Логарифмическая";
        approximation = String.format("%f*log(x)+%f",a,b);
    }

    @Override
    protected void solve(double[] X, double[] Y, int n) {
        double[] _X = X.clone();
        for (int i = 0; i < n; i++) {
            _X[i] = Math.log(_X[i]);
        }
        super.solve(_X, Y, n);
    }

    @Override
    public double phi(double x) {
        return a * Math.log(x) + b;
    }
}
