package fr.globostofo.baba_is_you_api.api.blocks;

import fr.globostofo.baba_is_you_api.api.blocks.types.ConnectionType;

public class Connection extends Block {

    private ConnectionType type;

    public Connection(int row, int col, ConnectionType type) {
        super(row, col);
        this.type = type;
    }

    public ConnectionType getType() {
        return type;
    }

    public void setType(ConnectionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.name();
    }
}
