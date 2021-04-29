package approximation;


abstract class HiddenLinear extends Approximation {

    protected double a;
    protected double b;

    protected HiddenLinear(double[] X, double[] Y, int n) {
        super(X,Y,n);
    }

    protected void solve(double[] X, double[] Y, int n){
        double SX = 0;
        double SXX = 0;
        double SY = 0;
        double SXY = 0;
        for (int i = 0; i < n; i++) {
            SX += X[i];
            SXX += Math.pow(X[i], 2);
            SY += Y[i];
            SXY += X[i] * Y[i];
        }
        double delta = SXX * n - SX * SX;
        double delta_1 = SXY * n - SX * SY;
        double delta_2 = SXX * SY - SX * SXY;
        a = delta_1 / delta;
        b = delta_2 / delta;
    }

}
