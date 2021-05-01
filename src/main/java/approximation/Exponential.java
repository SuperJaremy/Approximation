package approximation;


public class Exponential extends HiddenLinear {

    public Exponential(double[] X, double[] Y, int n) {
        super(X, Y, n);
        approximation = String.format("%f*e^(%f*x)", a, b);
        type = "Экспоненциальная";
    }

    @Override
    protected void solve(double[] X, double[] Y, int n) {
        double[] _Y = Y.clone();
        for (int i = 0; i < n; i++) {
            _Y[i] = Math.log(_Y[i]);
        }
        super.solve(X, _Y, n);
        double c = a;
        a = Math.exp(b);
        b = c;
    }

    @Override
    public double phi(double x) {
        return a * Math.exp(b * x);
    }
}
