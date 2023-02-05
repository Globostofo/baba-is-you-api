package fr.globostofo.baba_is_you_api.api;

import fr.globostofo.baba_is_you_api.api.blocks.*;
import fr.globostofo.baba_is_you_api.api.blocks.types.AttributeType;
import fr.globostofo.baba_is_you_api.api.blocks.types.ConnectionType;
import fr.globostofo.baba_is_you_api.api.blocks.types.EntityType;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Level {

    private final Grid grid;
//    private final BlocksManager<EntityType, Controller> controllers = new BlocksManager<>();
    private final BlocksManager<EntityType, Actor> actors = new BlocksManager<>();
//    private final BlocksManager<ConnectionType, Connection> connections = new BlocksManager<>();
//    private final BlocksManager<AttributeType, Attribute> attributes = new BlocksManager<>();
    private final Set<Connection> isBlocks = new HashSet<>();

    private final RulesManager rules = new RulesManager();

    public Level(int rows, int cols) {
        grid = new Grid(rows, cols);
    }

    public void addController(int row, int col, EntityType type) {
        Controller controller = new Controller(row, col, type);
        grid.set(row, col, controller);
//        controllers.add(controller);
    }

    public void addActor(int row, int col, EntityType type) {
        Actor actor = new Actor(row, col, type);
        grid.set(row, col, actor);
        actors.put(type, actor);
    }

    public void addConnection(int row, int col, ConnectionType type) {
        Connection connection = new Connection(row, col, type);
        grid.set(row, col, connection);
//        connections.put(type, connection);
        if (type == ConnectionType.IS) isBlocks.add(connection);
    }

    public void addAttribute(int row, int col, AttributeType type) {
        Attribute attribute = new Attribute(row, col, type);
        grid.set(row, col, attribute);
//        attributes.put(type, attribute);
    }

    public void start() {
        computeRules();
    }

    @Override
    public String toString() {
        return "Level {\n\trows = " + grid.getRows() +
                "\n\tcols = " + grid.getCols() +
                grid +
                '\n' + rules +
                "\n}";
    }

    private void computeRules() {
        for (Connection isBlock: isBlocks) {
            Map<Direction, Block> around = grid.getAround(isBlock.getRow(), isBlock.getCol());
            if (around.get(Direction.TOP) != null && around.get(Direction.TOP).getClass() == Controller.class && around.get(Direction.BOTTOM) != null && around.get(Direction.BOTTOM).getClass() == Attribute.class) {
                Controller c = (Controller) around.get(Direction.TOP);
                Attribute a = (Attribute) around.get(Direction.BOTTOM);
                rules.addRule(c.getType(), a.getType());
            }
            if (around.get(Direction.LEFT) != null && around.get(Direction.LEFT).getClass() == Controller.class && around.get(Direction.RIGHT) != null && around.get(Direction.RIGHT).getClass() == Attribute.class) {
                Controller c = (Controller) around.get(Direction.LEFT);
                Attribute a = (Attribute) around.get(Direction.RIGHT);
                rules.addRule(c.getType(), a.getType());
            }
        }
    }

    private void replaceActors(EntityType from, EntityType to) {
        for (Actor a: actors.getAll(from))
            a.setType(to);
        actors.putAll(to, actors.getAll(from));
        actors.removeAll(from);
    }

}
