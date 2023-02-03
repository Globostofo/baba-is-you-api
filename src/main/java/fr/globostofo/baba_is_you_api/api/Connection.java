package fr.globostofo.baba_is_you_api.api;

public class Connection extends Block {

    private ConnectionType type;

    public Connection(int row, int col, ConnectionType type) {
        super(row, col);
        this.type = type;
    }

    public ConnectionType getType() {
        return type;
    }

}
