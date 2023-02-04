package fr.globostofo.baba_is_you_api.api;

import fr.globostofo.baba_is_you_api.api.blocks.Block;

import java.util.Arrays;

public class Grid {

    private final int rows;
    private final int cols;
    private final Block[][] grid;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Block[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Block get(int row, int col) {
        return grid[row][col];
    }

    public void set(int row, int col, Block b) {
        grid[row][col] = b;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block[] row: grid)
            sb.append('\n').append(Arrays.toString(row));
        return sb.toString();
    }

}
