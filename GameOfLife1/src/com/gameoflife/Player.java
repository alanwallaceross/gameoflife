package com.gameoflife;


/**
 * The type Player.
 *
 * @author Alan
 */
class Player {
    private String name;
    private int chosenIterations;

    /**
     * Instantiates a new Player with a default name "Player" and a default number of iterations = 100.
     */
    Player(){
        name = "Player";
        chosenIterations = 100;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets chosen iterations.
     *
     * @return the chosen iterations
     */
    int getChosenIterations() {
        return chosenIterations;
    }

    /**
     * Sets chosen iterations.
     *
     * @param chosenIterations the chosen iterations
     */
    void setChosenIterations(int chosenIterations) {
        this.chosenIterations = chosenIterations;
    }

    /**
     * Step through one iteration.
     *
     * @param grid the grid
     */
    void step(Grid grid){
        grid.countNeighbours();
        grid.evolveCells();
        grid.printGrid();
    }

    /**
     * Play iterations.
     *
     * @param grid the grid
     */
    void playIterations(Grid grid){
        int i;
        for (i=1; i < chosenIterations; i++ ){
            grid.countNeighbours();
            grid.evolveCells();
            grid.printGrid();
            System.out.println();
            System.out.println();
        }
    }
}

