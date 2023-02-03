package fr.globostofo.baba_is_you_api.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Level {

    private final int rows;
    private final int cols;
    private final Block[][] grid;
    private final Map<EntityType, ArrayList<Controller>> controllersMap = new HashMap<>();
    private final Map<EntityType, ArrayList<Actor>> actorsMap = new HashMap<>();
    private final Map<EntityType, ArrayList<Connection>> connectionsMap = new HashMap<>();
    private final Map<EntityType, ArrayList<Attribute>> attributesMap = new HashMap<>();

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
