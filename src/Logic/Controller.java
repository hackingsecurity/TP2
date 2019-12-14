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
	private GamePrinter boardObjects;
	
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
		
		this.boardObjects = new GamePrinter(this.game);
	}
	
	public void run (){
		
		
		//PINTAMOS EL TABLERO EN EL ESTADO ACTUAL
		
		
	
		while (!game.isFinished()){
			
			draw();
			System.out.println(game.infoToString(this.boardObjects));
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
					if (!command.execute(game)) System.out.println("Unknown Command");
				else
					System.out.println("Unknown Command");
			
				}
			}catch (CommandParseException | CommmandExecuteException ex) {
				System.err.println(ex.getMessage());
			}
		
	}
		System.out.println(game.getWinnerMessage());
}
	}