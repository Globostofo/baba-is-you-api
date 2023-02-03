package fr.globostofo.baba_is_you_api.api;

public class Attribute extends Block {

    private AttributeType type;

    public Attribute(AttributeType type) {
        this.type = type;
    }

    public AttributeType getType() {
        return type;
    }

}
