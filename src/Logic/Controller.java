package Logic;

import Control.Command;
import Exeptions.*;

import java.util.Random;
import java.util.Scanner;
import Control.CommandGenerator;


public class Controller {

	private final String PROMPT = "\ncomannd > :";
	private Scanner scan;
	private Game game;
	private Level level;
	private BoardPrinter boardObjects;
	
	private boolean finPartida;
	private int cicloActual;
	private boolean reset;
	
	public Controller (Game game, Scanner scanner, Level level){
		this.game = game;
		this.level = level;
		this.scan = scanner;
		draw();
	}
	
	
	
	private void draw() {
		
		this.boardObjects = new BoardPrinter(this.game);
		System.out.println(game.infoToString(this.boardObjects));
	}
	
	public void run (){
		
		
		//PINTAMOS EL TABLERO EN EL ESTADO ACTUAL
		
		
		draw();
		while (!game.isFinished()){
			
			
			System.out.println(PROMPT);
			
			/*
			 * -scan.nextLine() -> lee la linea completa
			 * -toLowerCase()	-> Pone en minúsculas todas las letras
			 * -trim()			-> elimina los espacio en blanco
			 * -split()			-> Separa multiples espacios
			 */
			String[] words = scan.nextLine().toLowerCase().trim().split ("\\s+");
			
			try {
				
				Command command = CommandGenerator.parseCommand(words);

				
				if (command != null) {
					if (command.execute(game)) draw() ;
				else
					System.err.println();
			
				}
			}catch (CommandParseException | CommandExecuteException ex) {
				System.err.println(ex.getMessage());
			}
		
	}
		System.out.println(game.getWinnerMessage());
}
	}