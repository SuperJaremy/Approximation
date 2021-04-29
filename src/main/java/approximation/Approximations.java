package approximation;

import io.Input;

public enum Approximations {
    LINEAR(table -> new Linear(table.getX(), table.getY(), table.getN())),
    POLYNOMIAL(table -> new Polynomial(table.getX(), table.getY(), table.getN())),
    POWER(table -> new Power(table.getX(), table.getY(), table.getN())),
    EXPONENTIAL(table -> new Exponential(table.getX(), table.getY(), table.getN())),
    LOGARITHMIC(table -> new Logarithmic(table.getX(), table.getY(), table.getN()));

    TableToApproximation tableToApproximation;

    Approximations(TableToApproximation tableToApproximation) {
        this.tableToApproximation = tableToApproximation;
    }

    public Approximation solve(Input.Table table) {
        return tableToApproximation.apply(table);
    }

    private interface TableToApproximation {
        Approximation apply(Input.Table table);
    }
}
