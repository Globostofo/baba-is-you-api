package fr.globostofo.baba_is_you_api.api.blocks;

import fr.globostofo.baba_is_you_api.api.Vector2;
import fr.globostofo.baba_is_you_api.api.blocks.types.AttributeType;

public class Attribute extends Block {

    private AttributeType type;

    public Attribute(Vector2 position, AttributeType type) {
        super(position);
        this.type = type;
    }

    public AttributeType getType() {
        return type;
    }

    public void setType(AttributeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.name();
    }

}
