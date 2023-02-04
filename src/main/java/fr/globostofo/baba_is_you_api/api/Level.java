package fr.globostofo.baba_is_you_api.api;

import fr.globostofo.baba_is_you_api.api.blocks.*;
import fr.globostofo.baba_is_you_api.api.blocks.types.AttributeType;
import fr.globostofo.baba_is_you_api.api.blocks.types.ConnectionType;
import fr.globostofo.baba_is_you_api.api.blocks.types.EntityType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Level {

    private final int rows;
    private final int cols;
    private final Block[][] grid;
//    private final BlocksManager<EntityType, Controller> controllers = new BlocksManager<>();
    private final BlocksManager<EntityType, Actor> actors = new BlocksManager<>();
//    private final BlocksManager<ConnectionType, Connection> connections = new BlocksManager<>();
//    private final BlocksManager<AttributeType, Attribute> attributes = new BlocksManager<>();
    private final Set<Connection> isBlocks = new HashSet<>();

    private final RulesManager rules = new RulesManager();

    public Level(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Block[rows][cols];
    }

    public void addController(int row, int col, EntityType type) {
        Controller controller = new Controller(row, col, type);
        grid[row][col] = controller;
//        controllers.add(controller);
    }

    public void addActor(int row, int col, EntityType type) {
        Actor actor = new Actor(row, col, type);
        grid[row][col] = actor;
        actors.put(type, actor);
    }

    public void addConnection(int row, int col, ConnectionType type) {
        Connection connection = new Connection(row, col, type);
        grid[row][col] = connection;
//        connections.put(type, connection);
        if (type == ConnectionType.IS) isBlocks.add(connection);
    }

    public void addAttribute(int row, int col, AttributeType type) {
        Attribute attribute = new Attribute(row, col, type);
        grid[row][col] = attribute;
//        attributes.put(type, attribute);
    }

    public void start() {
        computeRules();
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

    private void computeRules() {

    }

    private void replaceActors(EntityType from, EntityType to) {
        for (Actor a: actors.getAll(from))
            a.setType(to);
        actors.putAll(to, actors.getAll(from));
        actors.removeAll(from);
    }

}
