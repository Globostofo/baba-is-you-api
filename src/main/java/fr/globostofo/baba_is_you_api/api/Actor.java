package fr.globostofo.baba_is_you_api.api;

public class Actor extends Block {

    private EntityType type;

    public Actor(EntityType type) {
        this.type = type;
    }

    public EntityType getType() {
        return type;
    }
}
