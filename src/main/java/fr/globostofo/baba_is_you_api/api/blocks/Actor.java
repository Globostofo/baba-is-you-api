package fr.globostofo.baba_is_you_api.api.blocks;

import fr.globostofo.baba_is_you_api.api.Vector2;
import fr.globostofo.baba_is_you_api.api.blocks.types.EntityType;

public class Actor extends Block {

    private EntityType type;

    public Actor(Vector2 position, EntityType type) {
        super(position);
        this.type = type;
    }

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.name();
    }

}
