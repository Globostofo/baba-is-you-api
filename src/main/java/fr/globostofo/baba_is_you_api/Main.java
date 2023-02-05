package fr.globostofo.baba_is_you_api;

import fr.globostofo.baba_is_you_api.api.*;
import fr.globostofo.baba_is_you_api.api.blocks.types.AttributeType;
import fr.globostofo.baba_is_you_api.api.blocks.types.ConnectionType;
import fr.globostofo.baba_is_you_api.api.blocks.types.EntityType;

public class Main {

    public static void main(String[] args) {
        Level lvl = new Level(new Vector2(18, 33));
        lvl.addController(new Vector2(6, 11), EntityType.BABA);
        lvl.addController(new Vector2(6, 19), EntityType.FLAG);
        lvl.addController(new Vector2(14, 11), EntityType.WALL);
        lvl.addController(new Vector2(14, 19), EntityType.ROCK);

        lvl.addActor(new Vector2(10, 12), EntityType.BABA);
        lvl.addActor(new Vector2(10, 20), EntityType.FLAG);
        for (int c=11; c<=21; ++c) {
            lvl.addActor(new Vector2(8, c), EntityType.WALL);
            lvl.addActor(new Vector2(12, c), EntityType.WALL);
        }
        for (int r=9; r<=11; ++r)
            lvl.addActor(new Vector2(r, 16), EntityType.ROCK);

        lvl.addConnection(new Vector2(6, 12), ConnectionType.IS);
        lvl.addConnection(new Vector2(6, 20), ConnectionType.IS);
        lvl.addConnection(new Vector2(14, 12), ConnectionType.IS);
        lvl.addConnection(new Vector2(14, 20), ConnectionType.IS);

        lvl.addAttribute(new Vector2(6, 13), AttributeType.YOU);
        lvl.addAttribute(new Vector2(6, 21), AttributeType.WIN);
        lvl.addAttribute(new Vector2(14, 13), AttributeType.STOP);
        lvl.addAttribute(new Vector2(14, 21), AttributeType.PUSH);

        lvl.start();

        System.out.println(lvl);
    }

}