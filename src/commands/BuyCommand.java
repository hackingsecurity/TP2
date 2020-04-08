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
		
		if(game.buySuperMissile()) buy =  true;
		else throw new CommandExecuteException("No tienes puntos suficientes, no puedes comprar super misil");
		
		return buy;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		
		
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 1) command = new BuyCommand();
			else throw new CommandParseException (incorrectNumArgsMsg);
			
		}
		
		return command;
	}

}
