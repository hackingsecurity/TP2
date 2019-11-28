package Control;

import Logic.Game;

//import Logic.Game;

public class MoveCommand extends Command{
	
	public MoveCommand() {
		super("move", "m", "move<left|right><1|2>", "Moves UCM-Ship to the indicated direction");
	}

	public boolean execute(Game game) {
		game.move();
		return true;
	}
	
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		//cadenas de caracteres
		if (matchCommandName(commandWords[0])) {
			command = new MoveCommand();
		}
		
		return command;
	}
	
}
