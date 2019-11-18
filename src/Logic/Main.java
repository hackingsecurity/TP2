package tp.p1;
import java.util.Scanner;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		
		Level level = Level.stringTolevel(args[0].toUpperCase());
		long seed = (args.length >1) ? Long.parseLong(args[1]): System.currentTimeMillis();
		Random rand = new Random(seed);
		Game game = new Game(level,rand);
		
		Controller controller = new Controller(game, new Scanner(System.in), level);
		controller.run();
	}

}
