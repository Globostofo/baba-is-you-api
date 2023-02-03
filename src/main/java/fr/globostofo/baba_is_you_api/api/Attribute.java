package fr.globostofo.baba_is_you_api.api;

public class Attribute extends Block {

    private AttributeType type;

    public Attribute(int row, int col, AttributeType type) {
        super(row, col);
        this.type = type;
    }

    public AttributeType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.name();
    }
}
