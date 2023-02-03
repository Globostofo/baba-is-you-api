package fr.globostofo.baba_is_you_api.api;

public class Controller extends Block {

    private EntityType type;

    public Controller(int row, int col, EntityType type) {
        super(row, col);
        this.type = type;
    }

    public EntityType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.name();
    }
}
