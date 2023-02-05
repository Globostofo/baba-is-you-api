package fr.globostofo.baba_is_you_api.api;

public record Vector2(int row, int col) {

    public static final Vector2 ZERO = new Vector2(0, 0);
    public static final Vector2 UP = new Vector2(-1, 0);
    public static final Vector2 LEFT = new Vector2(0, -1);
    public static final Vector2 DOWN = new Vector2(1, 0);
    public static final Vector2 RIGHT = new Vector2(0, 1);

    @Override
    public int row() {
        return row;
    }

    @Override
    public int col() {
        return col;
    }

    public Vector2 negate() {
        return new Vector2(-row, -col);
    }

    public Vector2 add(Vector2 v) {
        return new Vector2(row + v.row, col + v.col);
    }

    public boolean collides(Vector2 v1, Vector2 v2) {
        return Math.min(v1.row, v2.row) <= row && row <= Math.max(v1.row, v2.row) &&
                Math.min(v1.col, v2.col) <= col && col <= Math.max(v1.col, v2.col);
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }

}
