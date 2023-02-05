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

    public Level(Vector2 size) {
        grid = new Grid(size);
    }

    public void addController(Vector2 position, EntityType type) {
        Controller controller = new Controller(position, type);
        grid.set(position, controller);
//        controllers.add(controller);
    }

    public void addActor(Vector2 position, EntityType type) {
        Actor actor = new Actor(position, type);
        grid.set(position, actor);
        actors.put(type, actor);
    }

    public void addConnection(Vector2 position, ConnectionType type) {
        Connection connection = new Connection(position, type);
        grid.set(position, connection);
//        connections.put(type, connection);
        if (type == ConnectionType.IS) isBlocks.add(connection);
    }

    public void addAttribute(Vector2 position, AttributeType type) {
        Attribute attribute = new Attribute(position, type);
        grid.set(position, attribute);
//        attributes.put(type, attribute);
    }

    public void start() {
        computeRules();
    }

    @Override
    public String toString() {
        return "Level {\n\tsize=" + grid.size +
                grid +
                '\n' + rules +
                "\n}";
    }

    private void computeRules() {
        for (Connection isBlock: isBlocks) {
            Vector2 vUp = isBlock.getPosition().add(Vector2.UP);
            Vector2 vDown = isBlock.getPosition().add(Vector2.DOWN);
            Vector2 vLeft = isBlock.getPosition().add(Vector2.LEFT);
            Vector2 vRight = isBlock.getPosition().add(Vector2.RIGHT);
            // Vertical check
            if (grid.isInsideGrid(vUp) && grid.isInsideGrid(vDown)) {
                Block up = grid.get(vUp);
                Block down = grid.get(vDown);
                if (up != null && down != null) {
                    if (up.getClass() == Controller.class) {
                        if (down.getClass() == Attribute.class) {
                            Controller c = (Controller) up;
                            Attribute a = (Attribute) down;
                            rules.addRule(c.getType(), a.getType());
                        }
                    }
                }
            }
            // Horizontal check
            if (grid.isInsideGrid(vLeft) && grid.isInsideGrid(vRight)) {
                Block left = grid.get(vLeft);
                Block right = grid.get(vRight);
                if (left != null && right != null) {
                    if (left.getClass() == Controller.class) {
                        if (right.getClass() == Attribute.class) {
                            Controller c = (Controller) left;
                            Attribute a = (Attribute) right;
                            rules.addRule(c.getType(), a.getType());
                        }
                    }
                }
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
