package Control;

import Logic.Game;

public class UpdateCommand extends Command{
	public UpdateCommand() {
		super("none", " ", "[none]", "Skips one cycle");
	}

	public boolean execute(Game game) {
		
		game.update();
		return true;
	}
	
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		if (matchCommandName(commandWords[0])) {
			command = new UpdateCommand();
		}
		
		return command;
	}
	
}
