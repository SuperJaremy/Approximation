package approximation;


public class Power extends HiddenLinear {

    public Power(double[] X, double[] Y, int n) {
        super(X, Y, n);
        approximation = String.format("%f*x^%f", a, b);
    }

    @Override
    protected void solve(double[] X, double[] Y, int n) {
        double[] _X = X.clone();
        double[] _Y = Y.clone();
        for (int i = 0; i < n; i++) {
            _X[i] = Math.log(_X[i]);
            _Y[i] = Math.log(_Y[i]);
        }
        super.solve(_X, _Y, n);
        double c = a;
        a = Math.exp(b);
        b = c;
    }

    @Override
    public double phi(double x) {
        return a * Math.pow(x, b);
    }
}
