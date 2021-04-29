package io;

public abstract class Input {

    protected abstract double[][] readInput();

    public Table read(){
        double[][] data = readInput();
        if(data!=null)
            return new Table(data,data.length);
        else return null;
    }

    public class Table{
        private final double[] X;
        private final double[] Y;
        private final int n;

        private Table(double[][] data, int n){
            this.n = n;
            X = new double[n];
            Y = new double[n];
            for (int i = 0; i < n; i++) {
                X[i] = data[i][0];
                Y[i] = data[i][1];
            }
        }

        public double[] getX() {
            return X;
        }

        public double[] getY() {
            return Y;
        }

        public int getN() {
            return n;
        }
    }
}
