package com.gameoflife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The type Player test.
 */
class PlayerTest {

    /**
     * Sets get name.
     */
    @Test
    void testSetGetName() {
        Player player1 = new Player();
        player1.setName("Alan");
        Assertions.assertEquals("Alan", player1.getName());
    }

    /**
     * Sets get chosen iterations.
     */
    @Test
    void testSetGetChosenIterations() {
        Player player1 = new Player();
        player1.setChosenIterations(10);
        Assertions.assertEquals(10, player1.getChosenIterations());
    }

    /**
     * Step.
     */
    @Test
    void testStep() {
        Player player1 = new Player();
        Grid grid1 = new Grid();
        grid1.seedGridRandomly();
        grid1.printGrid();
        player1.step(grid1);
        grid1.printGrid();
    }

    /**
     * Play iterations.
     */
    @Test
    void testPlayIterations() {
        Player player1 = new Player();
        Grid grid1 = new Grid();
        grid1.seedGridRandomly();
        grid1.printGrid();
        player1.setChosenIterations(3);
        player1.playIterations(grid1);

    }
}