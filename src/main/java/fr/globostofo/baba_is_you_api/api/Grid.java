package fr.globostofo.baba_is_you_api.api;

import fr.globostofo.baba_is_you_api.api.blocks.Block;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Grid {

    private final int rows;
    private final int cols;
    private final Block[][] grid;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Block[rows][cols];
    }

    public boolean isInsideGrid(int row, int col) {
        return 0 <= row && row < rows && 0 <= col && col < cols;
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

    public Block getNeighbor(int row, int col, Direction d) {
        row += d.row;
        col += d.col;
        if (isInsideGrid(row, col)) return get(row, col);
        return null;
    }

    public Map<Direction, Block> getAround(int row, int col) {
        Map<Direction, Block> map = new HashMap<>();
        if (row == 0) map.put(Direction.TOP, null);
        else map.put(Direction.TOP, get(row-1, col));
        if (col == 0) map.put(Direction.LEFT, null);
        else map.put(Direction.LEFT, get(row, col-1));
        if (row == rows-1) map.put(Direction.BOTTOM, null);
        else map.put(Direction.BOTTOM, get(row+1, col));
        if (col == cols-1) map.put(Direction.RIGHT, null);
        else map.put(Direction.RIGHT, get(row, col+1));
        return map;
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
