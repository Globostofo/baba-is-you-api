package fr.globostofo.baba_is_you_api.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2Test {

    @Test
    void testConstant() {
        Vector2 v = Vector2.RIGHT;
        assertEquals("Vector2{row=0, col=1}", v.toString());
    }

    @Test
    void testOperations() {
        Vector2 v = new Vector2(500, -200);
        v = v.negate();
        v = v.add(Vector2.UP);
        assertEquals("Vector2{row=-501, col=200}", v.toString());
    }

    @Test
    void testCollides() {
        Vector2 v = new Vector2(500, 200);
        assertTrue(v.collides(Vector2.ZERO, new Vector2(500, 500)));
    }

    @Test
    void testCollides2() {
        Vector2 v = new Vector2(300, 200);
        assertTrue(v.collides(new Vector2(500, 0), new Vector2(0, 500)));
    }

    @Test
    void testCollides3() {
        Vector2 v = new Vector2(-500, 200);
        assertFalse(v.collides(new Vector2(500, 0), new Vector2(0, 500)));
    }

}