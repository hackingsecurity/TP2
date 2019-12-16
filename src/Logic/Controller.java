package Logic;
import Exeptions.*;
import board.BoardPrinter;
import comandos.Command;
import comandos.CommandGenerator;
import java.util.Random;
import java.util.Scanner;
import board.GamePrinter;
import board.PrinterTypes;
import board.Stringifier;


public class Controller {

	private Game game;
	private GamePrinter printer;
	private Level level;
	
	private final String PROMPT = "\ncomannd > :";
	private Scanner scan;

	
	public Controller (Game game, Scanner scanner, Level level){
		this.game = game;
		this.level = level;
		this.scan = scanner;
		
	}
	
	private void drawSerializable() {
		
		printer = new Stringifier();
		printer.setGamePrinter(game);
	}
	

	private void draw() {
	
		
		printer = new BoardPrinter();
		//INICIALIZAMOS EL GAME EN GAMEPRINTER
		printer.setGamePrinter(game);
		
		
	}
	
	public void run (){
		
		
		//PINTAMOS EL TABLERO EN EL ESTADO ACTUAL
		//draw();
		drawSerializable();
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
						
							//draw();
							drawSerializable();
							System.out.println(printer);
							
					}
			
				}else System.err.println("Unkown Command");
				
				
			}catch (CommandParseException | CommandExecuteException ex) {
				System.err.println(ex.getMessage());
			}
		
	}
		System.out.println(game.getWinnerMessage());
}
	}