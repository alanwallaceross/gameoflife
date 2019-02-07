package com.gameoflife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * The type Grid test.
 */
public class GridTest {

    /**
     * Test grid.
     */
    @Test
    void testGetGrid(){
        Grid grid = new Grid();
        Assertions.assertEquals(20, grid.getSize());
    }

    /**
     * Test set get column.
     */
    @Test
    void testSetGetColumn(){
        Grid grid = new Grid();
        grid.setChosenColumn(10);
        Assertions.assertEquals(10, grid.getChosenColumn());
    }

    /**
     * Test set get row.
     */
    @Test
    void testSetGetRow(){
        Grid grid = new Grid();
        grid.setChosenRow(10);
        Assertions.assertEquals(10, grid.getChosenRow());
    }

    /**
     * Test get cells.
     */
    @Test
    void testGetCells(){
        Grid grid = new Grid();
        grid.initializeDeadGrid();
        grid.setChosenRow(0);
        grid.setChosenColumn(0);
        grid.setIndividualCells();
        System.out.println(grid.getCells()[0][0]);
        Assertions.assertNotNull(grid.getCells()[0][0]);
    }

    /**
     * Test set get individual cells.
     */
    @Test
    void testSetGetIndividualCells() {
        Grid grid = new Grid();
        grid.setChosenRow(0);
        grid.setChosenColumn(0);
        grid.setIndividualCells();
        grid.setChosenRow(0);
        grid.setChosenColumn(0);
        grid.setIndividualCells();

        int count = 0;
        int i, j;
        for (i = 0; i < grid.getSize(); i++) {
            for (j = 0; j < grid.getSize(); j++) {
                if (grid.getCells()[i][j] != null) {
                    count++;
                }
                if (grid.getCells()[i][j] != null) {
                    count++;
                }

            }
        }
        Assertions.assertEquals(2, count);
    }

    /**
     * Test get size.
     */
    @Test
    void testGetSize() {
        Grid grid = new Grid();
        Assertions.assertEquals(20, grid.getSize());

    }

    /**
     * Test initialize dead grid.
     */
    @Test
    void testInitializeDeadGrid() {
        Grid grid = new Grid();
        grid.initializeDeadGrid();
        int count = 0;
        int i, j;
        for (i = 0; i < grid.getSize(); i++) {
            for (j = 0; j < grid.getSize(); j++) {
                if (grid.getCells()[i][j].isAlive()) {
                    count++;
                }
                }
            }
        Assertions.assertEquals(0, count);
        }

    /**
     * Test seed grid randomly.
     */
    @Test
    void testSeedGridRandomly() {
        Grid grid = new Grid();
        grid.seedGridRandomly();
        grid.printGrid();
    }

    /**
     * Test count neighbours.
     */
    @Test
    void testCountNeighbours() {
        Grid grid = new Grid();
        grid.initializeDeadGrid();
        grid.setChosenRow(0);
        grid.setChosenColumn(0);
        grid.setIndividualCells();
        grid.setChosenRow(0);
        grid.setChosenColumn(1);
        grid.setIndividualCells();
        grid.setChosenRow(1);
        grid.setChosenColumn(1);
        grid.setIndividualCells();
        grid.setChosenRow(1);
        grid.setChosenColumn(0);
        grid.setIndividualCells();
        grid.setChosenRow(19);
        grid.setChosenColumn(19);
        grid.setIndividualCells();
        grid.printGrid();
        grid.countNeighbours();
        Assertions.assertEquals(4, grid.getCells()[0][0].getNeighbours());
    }

    /**
     * Test evolve cells.
     */
    @Test
    void testEvolveCells() {
        Grid grid = new Grid();
        grid.initializeDeadGrid();
        grid.setChosenRow(10);
        grid.setChosenColumn(9);
        grid.setIndividualCells();
        grid.setChosenRow(10);
        grid.setChosenColumn(10);
        grid.setIndividualCells();
        grid.setChosenRow(10);
        grid.setChosenColumn(11);
        grid.printGrid();
        grid.countNeighbours();
        grid.evolveCells();
        grid.printGrid();
    }
}