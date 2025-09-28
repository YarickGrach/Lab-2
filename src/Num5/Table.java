package Num5;

public class Table {
    private int[][] data;

    public Table(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and cols must be positive");
        }
        this.data = new int[rows][cols];
        // Массив автоматически заполняется нулями в Java
    }

    public int getValue(int row, int col) {
        checkBounds(row, col);
        return data[row - 1][col - 1];
    }

    public void setValue(int row, int col, int value) {
        checkBounds(row, col);
        data[row - 1][col - 1] = value;
    }

    public int rows() {
        return data.length;
    }

    public int cols() {
        return data[0].length;
    }

    public double average() {
        if (rows() == 0 || cols() == 0) {
            return 0.0;
        }

        double sum = 0;
        int count = 0;

        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                sum += data[i][j];
                count++;
            }
        }

        return sum / count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                sb.append(data[i][j]);
                if (j < cols() - 1) {
                    sb.append(" ");
                }
            }
            if (i < rows() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private void checkBounds(int row, int col) {
        if (row - 1 < 0 || row - 1 >= rows() || col - 1 < 0 || col - 1 >= cols()){
            throw new IndexOutOfBoundsException(
                    "Index (" + row + ", " + col + ") is out of bounds for table " +
                            rows() + "x" + cols()
            );
        }
    }
}
