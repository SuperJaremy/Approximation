package approximation;

import helpers.GaussianElimination;


public class Polynomial extends Approximation {

    private double a_0;
    private double a_1;
    private double a_2;

    public Polynomial(double[] X, double[] Y, int n) {
        super(X, Y, n);
        type = "Квадратичная";
        approximation = String.format("%f*x^2+%f*x+%f", a_0, a_1, a_2);
    }

    @Override
    protected void solve(double[] X, double[] Y, int n) {
        double[][] A = new double[3][3];
        double[] b = new double[3];
        A[0][0] = n;
        double sumX = 0;
        double sumXSq = 0;
        double sumXCb = 0;
        double sumXFourth = 0;
        double sumY = 0;
        double sumYX = 0;
        double sumYXSq = 0;
        for (int i = 0; i < n; i++) {
            sumX += X[i];
            sumXSq += Math.pow(X[i], 2);
            sumXCb += Math.pow(X[i], 3);
            sumXFourth += Math.pow(X[i], 4);
            sumY += Y[i];
            sumYX += X[i] * Y[i];
            sumYXSq += Math.pow(X[i], 2) * Y[i];
        }
        A[0][1] = A[1][0] = sumX;
        A[0][2] = A[1][1] = A[2][0] = sumXSq;
        A[1][2] = A[2][1] = sumXCb;
        A[2][2] = sumXFourth;
        b[0] = sumY;
        b[1] = sumYX;
        b[2] = sumYXSq;
        double[] solution = GaussianElimination.lsolve(A, b);
        a_0 = solution[0];
        a_1 = solution[1];
        a_2 = solution[2];
    }

    @Override
    public double phi(double x) {
        return a_2 * Math.pow(x, 2) + a_1 * x + a_0;
    }


}
