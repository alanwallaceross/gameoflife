package com.gameoflife;

/**
 * The type Grid.
 *
 * @author Alan
 */
class Grid {
    private final Cell[][] cells;
    private int chosenRow;
    private int chosenColumn;
    private int size;


    /**
     * Instantiates a new Grid with a 2 dimensional Cell Array of length 20.
     */
    Grid() {
        cells = new Cell[20][20];
        chosenRow = 0;
        chosenColumn = 0;
    }

    /**
     * Get cells cell [ ] [ ].
     *
     * @return the cell [ ] [ ]
     */
    Cell[][] getCells() {
        return cells;
    }


    /**
     * Gets size.
     *
     * @return the size
     */
    Integer getSize() {
        return cells.length;
    }

    /**
     * Gets row.
     *
     * @return the row
     */
    int getChosenRow() {
        return chosenRow;
    }

    /**
     * Sets row.
     *
     * @param row the row
     */
    void setChosenRow(int row) {
        this.chosenRow = row;
    }

    /**
     * Gets column.
     *
     * @return the column
     */
    int getChosenColumn() {
        return chosenColumn;
    }

    /**
     * Sets column.
     *
     * @param column the column
     */
    void setChosenColumn(int column) {
        this.chosenColumn = column;
    }

    /**
     * Print grid.
     */
    void printGrid() {
        int i, j;
        for (i = 0; i < cells.length; i++) {
            for (j = 0; j < cells.length; j++) {
                System.out.print(cells[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Initialize grid full of dead cells.
     */
    void initializeDeadGrid() {
        int i, j;
        for (i = 0; i < cells.length; i++) {
            for (j = 0; j < cells.length; j++) {
                cells[i][j] = new Cell(false);
            }
        }
    }

    /**
     * Sets individual live cells in a specified position of the grid based on the grids row and column fields.
     */
    void setIndividualCells() {
        cells[chosenRow][chosenColumn] = new Cell(true);
    }

    /**
     * Seed grid randomly with dead cells and live cells.
     */
    void seedGridRandomly() {
        int i, j;
        for (i = 0; i < cells.length; i++) {
            for (j = 0; j < cells.length; j++) {
                cells[i][j] = new Cell(1);
        }
        }
    }

    /**
     * Count the number of live neighbours each cell has and give each count to each cell.
     */
    void countNeighbours() {
        int count = 0;
        int i, j;
        for (i = 0; i < cells.length; i++) {
            for (j = 0; j < cells[0].length; j++) {
                if (cells[i][(j + 1) % cells.length].isAlive()) {
                    count++;
                }
                if (cells[(i + 1) % cells.length][(j + 1) % cells.length].isAlive()) {
                    count++;
                }
                if (cells[(i + 1) % cells.length][j].isAlive()) {
                    count++;
                }
                if (cells[(i + 1) % cells.length][((j - 1) % cells.length + cells.length) % cells.length].isAlive()) {
                    count++;
                }
                if (cells[i][((j - 1) % cells.length + cells.length) % cells.length].isAlive()) {
                    count++;
                }
                if (cells[((i - 1) % cells.length + cells.length) % cells.length ][((j - 1) % cells.length + cells.length) % cells.length].isAlive()) {
                    count++;
                }
                if (cells[((i - 1) % cells.length + cells.length) % cells.length][j].isAlive()) {
                    count++;
                }
                if (cells[((i - 1) % cells.length + cells.length) % cells.length][(j + 1) % cells.length].isAlive()) {
                    count++;
                }
                cells[i][j].setNeighbours(count);
                count = 0;

            }
        }
    }

    /**
     * Evolve cells.
     */
    void evolveCells() {
        int i, j;
        for (i = 0; i < cells.length; i++) {
            for (j = 0; j < cells.length; j++) {
                cells[i][j].actOnNeighbourCount();
            }
        }
    }
}










