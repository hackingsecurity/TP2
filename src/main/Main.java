package main;
import java.util.Scanner;
import controller.Controller;
import logic.*;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		
		//llamamos al método static de Level
		Level level = Level.parse(args[0].toUpperCase());
		
		long seed = (args.length >1) ? Long.parseLong(args[1]): System.currentTimeMillis();
		Random rand = new Random(seed);
		Game game = new Game(level,rand);
		
		Controller controller = new Controller(game, new Scanner(System.in), level);
		controller.run();
	}

}
