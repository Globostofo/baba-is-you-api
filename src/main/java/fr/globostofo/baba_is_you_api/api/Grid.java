package fr.globostofo.baba_is_you_api.api;

import fr.globostofo.baba_is_you_api.api.blocks.Block;

import java.util.Arrays;

public class Grid {

    public final Vector2 size;
    private final Block[][] grid;

    public Grid(Vector2 size) {
        this.size = size;
        grid = new Block[this.size.row()][this.size.col()];
    }

    public boolean isInsideGrid(Vector2 position) {
        return position.collides(Vector2.ZERO, size.add(Vector2.UP).add(Vector2.LEFT));
    }

    public Block get(Vector2 position) {
        return grid[position.row()][position.col()];
    }

    public void set(Vector2 position, Block block) {
        grid[position.row()][position.col()] = block;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block[] row: grid)
            sb.append('\n').append(Arrays.toString(row));
        return sb.toString();
    }

}
