package fr.globostofo.baba_is_you_api.api.blocks;

import fr.globostofo.baba_is_you_api.api.Vector2;

public abstract class Block {

    private Vector2 position;

    public Block(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

}
