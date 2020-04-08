package main;
import java.util.Scanner;
import controller.Controller;
import logic.*;
import utils.Level;

import java.util.Random;

/**
 *	Inicio de nuestro juego
 *
 * 	-Nos quedamos en la pagina 8
 * 
 * 
 * 	//No debe estar aqui
	public void getDamage (int damage) {
		this.live = (damage >= this.live) ? 0 : (this.live - damage);
	}
	
 *
 *
 */
public class Main {

	//esto es nuevo
	
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
