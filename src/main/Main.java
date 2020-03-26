package main;
import java.util.Scanner;
import controller.Controller;
import logic.*;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		
		//Llamamos al método estático de Level ->Default EASY
		Level level = Level.parse(args[0].toUpperCase());
		
		//Inicializamos con un número como segundo argumento -> Default tiempo en milisegundos
		long seed = (args.length >1) ? Long.parseLong(args[1]): System.currentTimeMillis();
		
		//Inicializamos nuestra semilla ->Defaul Seudoaleatorio
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
