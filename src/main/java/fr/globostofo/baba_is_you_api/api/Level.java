package fr.globostofo.baba_is_you_api.api;

import java.util.Arrays;

public class Level {

    private int rows;
    private int cols;
    private Block[][] grid;

    public Level(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Block[rows][cols];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Level {");
        sb.append("\n\trows = ").append(rows);
        sb.append("\n\tcols = ").append(cols);
        for (Block[] row: grid)
            sb.append("\n\t").append(Arrays.toString(row));
        sb.append("\n}");
        return sb.toString();
    }
}
