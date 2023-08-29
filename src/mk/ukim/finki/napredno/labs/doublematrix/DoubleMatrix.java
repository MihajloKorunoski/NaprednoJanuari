package mk.ukim.finki.napredno.labs.doublematrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class DoubleMatrix {

    private final double[][] matrix;

    public DoubleMatrix(double[] array, int row, int column) throws InsufficientElementsException {
        if (array.length < row * column)
            throw new InsufficientElementsException();

        matrix = new double[row][column];
        int k = array.length - (row * column);
        for (int i = 0; i < row; ++i)
            for (int j = 0; j < column; ++j)
                matrix[i][j] = array[k++];
    }


    public String getDimensions() {
        return String.format("[%d x %d]", matrix.length, matrix[0].length);
    }

    public int rows() {
        return matrix.length;
    }

    public int columns() {
        return matrix[0].length;
    }

    public double maxElementAtRow(int row) throws InvalidRowNumberException {
        if (row < 1 || row > rows())
            throw new InvalidRowNumberException();
        return Arrays.stream(matrix[row - 1])
                .max()
                .orElse(0);
    }

    public double maxElementAtColumn(int col) throws InvalidColumnNumberException {
        if (col < 1 || col > columns())
            throw new InvalidColumnNumberException();

        return Arrays.stream(matrix)
                .mapToDouble(row -> row[col - 1])
                .max()
                .orElse(0);
    }

    public double[] toSortedArray() {
        return Arrays.stream(matrix)
                .flatMapToDouble(Arrays::stream)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToDouble(Double::doubleValue)
                .toArray();
    }

    public double sum() {
        return Arrays.stream(matrix)
                .flatMapToDouble(Arrays::stream)
                .sum();
    }

    @Override
    public String toString() {
        return Arrays.stream(matrix)
                .map(row -> Arrays.stream(row)
                        .mapToObj(x -> String.format("%.2f", x))
                        .collect(Collectors.joining("\t")))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleMatrix that = (DoubleMatrix) o;
        return Arrays.deepEquals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }
}
