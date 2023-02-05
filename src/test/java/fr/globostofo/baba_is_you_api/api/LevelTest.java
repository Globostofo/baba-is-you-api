package fr.globostofo.baba_is_you_api.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    @Test
    void testLevel() {
        Level lvl = new Level(new Vector2(2, 3));
        assertEquals("Level {\n\tsize=Vector2{row=2, col=3}\n[null, null, null]\n[null, null, null]\nRulesManager{{}, you=[]}\n}", lvl.toString());
    }

}