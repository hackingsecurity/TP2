package comandos;

import Exeptions.CommandParseException;
import Logic.Game;

public class UpdateCommand extends Command{
	public UpdateCommand() {
		super("none", "", "[none]", "Skips one cycle");
	}

	public boolean execute(Game game) {
		
		game.update();
		return true;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException
	{
		Command command = null;
		
		if (matchCommandName(commandWords[0])) {
			
			if(commandWords.length == 1) command = new UpdateCommand();
			else throw new CommandParseException (incorrectNumArgsMsg);
			
		}
		
		return command;
	}
	
}
