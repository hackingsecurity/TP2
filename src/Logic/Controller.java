package Logic;

import java.util.Random;
import java.util.Scanner;

import Control.Command;
import Control.CommandGenerator;


public class Controller {

	private Scanner scan;
	private Game game;
	private GamePrinter gamePrinter;
	private Level level;
	private Random ran;
	private Command command;
	
	
	private boolean finPartida;
	private int cicloActual;
	private boolean reset;
	
	public Controller (Game game, Scanner scanner, Level level){
		this.game = game;
		this.level = level;
		this.ran = game.getRandom();
		this.scan = scanner;
	}
	
	
	public void run (){
	
		while (!game.isFinished()){
			
			//MUESTRA EL TABLERO DEL JUEGO
			System.out.println(PROMPT);
			
			/*
			 * -scan.nextLine() -> lee la linea completa
			 * -toLowerCase()	-> Pone en minúsculas todas las letras
			 * -trim()			-> elimina los espacio en blanco
			 * -split()			-> Separa multiples espacios
			 */
			
			String[] words = scan.nextLine().toLowerCase().trim().split ("\\s+");
			
			//llamamos al metodo static de CommandGenerator
			
			Command command = CommandGenerator.parseCommand(words);
			
			if (command != null) {
			if (command.execute(game))
				
			System.out.println(game);
		}
		else {
		System.out.format(unknownCommandMsg);
		}
	}
		
}