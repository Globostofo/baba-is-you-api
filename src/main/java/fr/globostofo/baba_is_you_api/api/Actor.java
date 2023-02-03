package fr.globostofo.baba_is_you_api.api;

public class Actor extends Block {

    private EntityType type;

    public Actor(int row, int col, EntityType type) {
        super(row, col);
        this.type = type;
    }

    public EntityType getType() {
        return type;
    }
}
