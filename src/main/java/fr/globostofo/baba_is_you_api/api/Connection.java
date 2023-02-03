package fr.globostofo.baba_is_you_api.api;

public class Connection extends Block {

    private ConnectionType type;

    public Connection(ConnectionType type) {
        this.type = type;
    }

    public ConnectionType getType() {
        return type;
    }

}
