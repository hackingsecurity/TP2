package commands;

import exceptions.*;
import logic.Game;

public class BuyCommand extends Command{

	public BuyCommand() {
		super("buy", "b", "buy Super Missile", "Buy supermisil for 20 point");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {

		boolean buy = false;
		
		try {
			if(game.buySuperMissile()) buy =  true;
			else throw new CommandExecuteException("No tienes puntos suficientes, no puedes comprar super misil");
		}
		catch(CommandExecuteException e) {
			 throw new CommandExecuteException(e.getMessage());
		}
		
		return buy;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		
		try {
			
			if (matchCommandName(commandWords[0])) {
				if (commandWords.length == 1) command = new BuyCommand();
				else throw new CommandParseException (incorrectNumArgsMsg);	
			}
		}
		catch (CommandParseException e) {
			throw new CommandParseException(e.getMessage());
		}
		
		return command;
	}

}
