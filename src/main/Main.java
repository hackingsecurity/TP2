package main;
import java.util.Scanner;
import controller.Controller;
import logic.*;
import utils.Level;

import java.util.Random;

/**
 *	Inicio de nuestro juego
 *
 *
 *
 */
public class Main {

	
	public static void main(String[] args) {
		
		//Inicializamos nuestra semilla por defecto.
		long seed = 0l;
		
		/**
		 * Si nuestros argumento son igual a 0 es decir no tenemos argumento o tenemos mas de dos argumentos.
		 * 
		 * try - catch 
		 */
		if(!(args.length == 0 || args.length > 2)) {
			
			if(Level.parse(args[0]) == null) {
				
				System.err.println("Usage: Main <EASY|HARD|INSANE> [seed]: level must be one of: EASY, HARD, INSANE");
			}else {
				
				Level level = Level.parse(args[0].toUpperCase());
				
				try {
					//Si solo metemos el nivel del juego, debemos inicializar nuestra semilla.
					//Inicializamos con un número como segundo argumento -> Default tiempo en milisegundos
					 seed =  (args.length >1) ? Long.parseLong(args[1]): System.currentTimeMillis();
					 
				}catch(NumberFormatException e) {
					
					System.err.println("Usage: Main <EASY|HARD|INSANE> [seed]: the seed must be a number");
					
				}
				
				//Instanciamos nuestra variable rand con la semilla que hemos definidio anteriormente.
				Random rand = new Random(seed);
				
				//Inicializamos nuestro game
				Game game = new Game(level,rand);
				
				/*Inicializamos nuestro controler
				 *  
				 *   Scanner(System.in) -> Entrada inputStream
				 */
				Controller controller = new Controller(game, new Scanner(System.in), level);
				controller.run();
				
			}
			
			
			
	}
	else {
		System.err.println(" Usage: Main <EASY|HARD|INSANE> [seed] ");
	}
		

	}
}
