package mk.ukim.finki.napredno.labs.doublematrix;

import java.io.InputStream;
import java.util.Scanner;

class MatrixReader {
    public static DoubleMatrix read(InputStream inputStream) throws InsufficientElementsException {
        Scanner scanner = new Scanner(inputStream);
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        double[] matrix = new double[row * column];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextDouble();
        }
        return new DoubleMatrix(matrix, row, column);
    }
}
