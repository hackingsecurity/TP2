package Control;

import Logic.Game;

public class ExitCommand extends Command{


	public abstract boolean execute(Game game);
	
	public abstract Command parse(String[] commandWords);
	
}
