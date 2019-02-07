package com.gameoflife;
import java.util.Scanner;


/**
 * The type User interface.
 *
 * @author Alan
 */
class UserInterface {
    private final Player player;
    private final Grid grid;

    /**
     * Instantiates a new User interface.
     *
     * @param player the player
     * @param grid   the grid
     */
    UserInterface(Player player, Grid grid) {
        this.player = player;
        this.grid = grid;
        this.createDeadGrid();
    }

    /**
     * Take commands.
     */
    void takeCommands() {
        System.out.println("Instructions:");
        System.out.println("To quit, enter 0.");
        System.out.println("To run your chosen iterations of the game of life (the default number of iterations is 100), enter 1.");
        System.out.println("To run one iteration of the game of life, enter 2.");
        System.out.println("To reset the grid to a random state, enter 3.");
        System.out.println("To choose the number of iterations you want, enter 4.");
        System.out.println("To create a grid full of dead cells, enter 5");
        System.out.println("To set a live cell in a specific position of the grid, enter 6");
        System.out.println("To print the grid, enter 7");
        System.out.println("To set the name of your player, enter 8");
        System.out.println();
        System.out.println("Once you know what you want to do, type the number corresponding to what you want to do and then type enter.");
        Scanner s = new Scanner(System.in);
        int inputFromUser = s.nextInt();
        if (inputFromUser == 0){
            System.out.println("You have quit.");
            System.exit(0);
        }
        else if (inputFromUser == 1){
            startGameOfLife();
        }
        else if(inputFromUser == 2){
            oneStep();
        }
        else if(inputFromUser == 3){
            resetGrid();
        }
        else if(inputFromUser == 4){
            chooseIterations();
        }

        else if(inputFromUser == 5){
            createDeadGrid();
        }

        else if(inputFromUser == 6){
            setCells();
        }

        else if(inputFromUser == 7){
            printGrid();
        }

        else if(inputFromUser == 8){
            setName();
        }

        else {
            System.out.println("You have not inputted a correct command number. Please try inputting a number from 1 to 8. If you want to quit however, input 0.");
            System.out.println();
        }
    }

    private void startGameOfLife() {
        grid.printGrid();
        player.playIterations(grid);
        System.out.println("You have successfully played through your chosen number of iterations.");
        System.out.println();
    }

    private void oneStep(){
        player.step(grid);
        System.out.println("You have successfully evolved the Game Of Life by one step.");
        System.out.println();
    }

    private void resetGrid(){
        grid.seedGridRandomly();
        System.out.println("You have successfully reset the grid. The grid is now randomly distributed with live and dead cells, you can enter '7' to see them.");
        System.out.println();

    }

    private void chooseIterations(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please input the number of iterations you would like. The range of possible iterations are from 1 to 1000.");
        int inputFromUser = s.nextInt();
        if (inputFromUser >= 1 && inputFromUser <= 1000){
            player.setChosenIterations(inputFromUser);
        }
        else{
            System.out.print("Invalid entry. You have not input a number in the range of 1 to 1000. Please try again.");
        }

        System.out.println("You have successfully set " + inputFromUser + " as your chosen number of iterations.");
        System.out.println();
    }

    private void createDeadGrid(){
        grid.initializeDeadGrid();
        System.out.println("You have successfully created a grid full of dead cells, you can enter '7' to see them.");
        System.out.println();
    }

    private void setCells(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter what row you would like to enter your cell in. The integer can be 0-19.");
        int inputFromUser = s.nextInt();
        if (inputFromUser >= 0 && inputFromUser < grid.getSize()){
            grid.setChosenRow(inputFromUser);
            System.out.println("You have set " + inputFromUser + " as your row.");
        }
        else{
            System.out.println("Invalid entry. You have not inputted an integer from 0 to 19. Please try again.");
            setCells();
        }
        System.out.println("Please enter what column you would like to enter your cell in. The number can be 0-19.");
        int inputFromUser1 = s.nextInt();
        if (inputFromUser1 >=0 && inputFromUser1 < grid.getSize()){
            grid.setChosenColumn(inputFromUser1);
            System.out.println("You have set " + inputFromUser1 + " as your column.");
        }
        else{
            System.out.println("Invalid entry. You have not inputted an integer from 0 to 19. Please try again.");
            setCells();
        }
        grid.setIndividualCells();
        System.out.println("You have now set your cell into coordinates ["+ inputFromUser +"][" + inputFromUser1 + "]");
        System.out.println();
    }

    private void printGrid(){
        grid.printGrid();
        System.out.println("You have just printed the grid.");
        System.out.println();
    }

    private void setName(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please type in your name.");
        String inputFromUser = s.nextLine();
        if (inputFromUser.isEmpty()){
            System.out.println("Invalid entry. You have not entered any characters, please try again.");
            setName();
        }
        player.setName(inputFromUser);
        System.out.println("You have now set your name to " + inputFromUser + ".");
        System.out.println();
    }
}
