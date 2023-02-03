package fr.globostofo.baba_is_you_api.api;

public class Controller extends Block {

    private EntityType type;

    public Controller(EntityType type) {
        this.type = type;
    }

    public EntityType getType() {
        return type;
    }

}
