package controller;
import board.BoardPrinter;
import logic.Game;
import utils.CommandGenerator;
import utils.Level;

import java.util.Random;
import java.util.Scanner;
import board.GamePrinter;
import board.PrinterTypes;
import board.Stringifier;
import commands.Command;
import exceptions.*;


public class Controller {

	private Game game;
	private GamePrinter printer;
	private Level level;
	
	private final String PROMPT = "\ncommand > :";
	private Scanner scan;

	
	public Controller (Game game, Scanner scanner, Level level){
		this.game = game;
		this.level = level;
		this.scan = scanner;
		
	}

	
	public void run (){
		
		
		//PINTAMOS EL TABLERO EN EL ESTADO ACTUAL
		
		/*drawSerializable();
		* no has usado PrinterTypes para crear impresoras
	    + printer = PrinterTypes.BOARDPRINTER.getObject(game)
	    */
		
		printer = PrinterTypes.BOARDPRINTER.getObject(this.game);
		System.out.println(printer);
		
		
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
					
					if (command.execute(game)) {
						
						
							//drawSerializable();
						/*drawSerializable();
						* no has usado PrinterTypes para crear impresoras
					    + printer = PrinterTypes.BOARDPRINTER.getObject(game)	
					    */
						printer = PrinterTypes.BOARDPRINTER.getObject(this.game);
						System.out.println(printer);
						
							
					}
			
				}else System.err.println("Unknown Command");
				
				
			}catch (CommandParseException | CommandExecuteException | NumberFormatException ex) {
				System.err.println(ex.getMessage());
			}
		
	}
		System.out.println(game.getWinnerMessage());
}
	}