package com.gameoflife;
import java.util.Random;

/**
 * The type Cell.
 *
 * @author Alan
 */
class Cell {
    private boolean isAlive;
    private int isRandom;
    private String appearance;
    private int neighbours;

    /**
     * Instantiates a new Cell with a boolean which determines if the cell is alive or not.
     *
     * @param isAlive the is alive
     */
    Cell(boolean isAlive){
        this.isAlive = isAlive;
        setAppearance();
    }

    /**
     * Instantiates a new Cell with an integer that determines if its state is random or not.
     *
     * @param isRandom the is random
     */
    Cell(int isRandom){
        this.isRandom = isRandom;
        randomizeState(isRandom);
        setAppearance();
    }

    /**
     * Is alive boolean.
     *
     * @return the boolean
     */
    boolean isAlive() {
        return isAlive;
    }

    /**
     * Sets alive.
     *
     * @param alive the alive
     */
    void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Is random int.
     *
     * @return the int
     */
    public int IsRandom() {
        return isRandom;
    }

    /**
     * Sets is random.
     *
     * @param isRandom the is random
     */
    public void setIsRandom(int isRandom) {
        this.isRandom = isRandom;
    }

    /**
     * Gets neighbours.
     *
     * @return the neighbours
     */
    int getNeighbours() {
        return neighbours;
    }

    /**
     * Sets neighbours.
     *
     * @param neighbours the neighbours
     */
    void setNeighbours(int neighbours) {
        this.neighbours = neighbours;
    }

    private void die(){
        isAlive = false;
        setAppearance();
    }

    private void reawaken(){
        isAlive = true;
        setAppearance();
    }

    @SuppressWarnings("EmptyMethod")
    private void survive(){
    }

    /**
     * Act on neighbour count.
     */
    void actOnNeighbourCount() {
        if (neighbours == 3) {
            reawaken();
        } else if (neighbours == 2) {
            survive();
        } else if (neighbours > 3) {
            die();
        } else {
            die();
        }
    }

    private void randomizeState(int isRandom){
        Random random = new Random();
        if (isRandom == 1){
            isAlive = random.nextBoolean();
        }
    }

    private void setAppearance(){
        if(isAlive){
            appearance = "*";
        }
        else {
            appearance = ".";
        }
    }

    @Override
    public String toString() {
        return appearance;
    }

}
