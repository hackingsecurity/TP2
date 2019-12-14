package comandos;

import Exeptions.*;
import Logic.Game;

public class ShockwaveCommand extends Command{
	
	public ShockwaveCommand() {
		super("shockwave", "w", "shockWave", "UCM-Ship releases a shock wave");
	}

	public boolean execute(Game game) throws CommandExecuteException {
	
		boolean  ex = false;
		
		if(game.shockWave()){
			game.enableShockWave();
			game.update();
			ex = true;
	
			
		}else throw new CommandExecuteException("There isn't ShockWave");
		
		return ex;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException
	{
		Command command = null;
		
		if (commandWords.length == 1) {
			if (matchCommandName(commandWords[0])) {
				command = new ShockwaveCommand();
			}
		}else throw new CommandParseException (incorrectNumArgsMsg);
		
		return command;
	}
	
}
