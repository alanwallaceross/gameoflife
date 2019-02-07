package com.gameoflife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * The type Cell test.
 */
public class CellTest {

    /**
     * Sets get alive.
     */
    @Test
    void testSetGetAlive() {
        Cell cell1 = new Cell(true);
        cell1.setAlive(false);
        Assertions.assertFalse(cell1.isAlive());
    }

    /**
     * Die underpopulation.
     */
    @Test
    void testDieUnderpopulation() {
        Cell cell1 = new Cell(true);
        cell1.setNeighbours(1);
        cell1.actOnNeighbourCount();
        Assertions.assertFalse(cell1.isAlive());
    }

    /**
     * Die overpopulation.
     */
    @Test
    void testDieOverpopulation() {
        Cell cell1 = new Cell(true);
        cell1.setNeighbours(4);
        cell1.actOnNeighbourCount();
        Assertions.assertFalse(cell1.isAlive());
    }

    /**
     * Reawaken.
     */
    @Test
    void testReawaken() {
        Cell cell1 = new Cell(false);
        cell1.setNeighbours(3);
        cell1.actOnNeighbourCount();
        Assertions.assertTrue(cell1.isAlive());
    }

    /**
     * Survive.
     */
    @Test
    void testSurvive() {
        Cell cell1 = new Cell(true);
        cell1.setNeighbours(3);
        cell1.actOnNeighbourCount();
        cell1.setNeighbours(2);
        cell1.actOnNeighbourCount();
        Assertions.assertTrue(cell1.isAlive());
    }

    /**
     * Act on neighbour count.
     */
    @Test
    void testActOnNeighbourCount() {
        Cell cell1 = new Cell(true);
        cell1.actOnNeighbourCount();
        Assertions.assertFalse(cell1.isAlive());

    }
}