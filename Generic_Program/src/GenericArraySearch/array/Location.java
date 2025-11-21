package GenericArraySearch.array;

public class Location<T extends Comparable<T>> {
    private int row;
    private int column;
    private T value;

    private Location(int row, int column, T value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Location [row=" + row + ", column=" + column + ", value=" + value + "]";
    }

    public static <E extends Comparable<E>> Location<E> findMax(E[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        E max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].compareTo(max) > 0) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        return new Location<>(maxRow, maxCol, max);
    }

    public static <E extends Comparable<E>> Location<E> findMin(E[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        E min = matrix[0][0];
        int minRow = 0;
        int minCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].compareTo(min) < 0) {
                    min = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        return new Location<>(minRow, minCol, min);
    }
}