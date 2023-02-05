package fr.globostofo.baba_is_you_api.api;

public enum Direction {
    TOP(-1, 0),
    LEFT(0, -1),
    BOTTOM(1, 0),
    RIGHT(0, 1);

    public final int row;
    public final int col;

    Direction(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
