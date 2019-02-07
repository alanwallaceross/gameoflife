package com.gameoflife;

import java.util.Scanner;

/**
 * The type Main.
 *
 * @author Alan
 */
class Main {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
    	Scanner sys = new Scanner(System.in);
    	System.out.println("Welcome to Conway's Game of Life");
    	System.out.println("Please enter any integer except 9 to open the user interface");
    	int inputFromUser = sys.nextInt();
    	Player player1 = new Player();
		Grid grid1 = new Grid();

    	UserInterface ui1 = new UserInterface(player1, grid1);
		//noinspection LoopConditionNotUpdatedInsideLoop
		while (inputFromUser != 9){
    		ui1.takeCommands();
		}
	}
}
