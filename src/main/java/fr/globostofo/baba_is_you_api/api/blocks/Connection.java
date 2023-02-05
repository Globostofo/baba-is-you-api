package fr.globostofo.baba_is_you_api.api.blocks;

import fr.globostofo.baba_is_you_api.api.Vector2;
import fr.globostofo.baba_is_you_api.api.blocks.types.ConnectionType;

public class Connection extends Block {

    private ConnectionType type;

    public Connection(Vector2 position, ConnectionType type) {
        super(position);
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
