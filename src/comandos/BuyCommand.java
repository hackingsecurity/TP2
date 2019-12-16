package comandos;

import Exeptions.*;
import Logic.Game;

public class BuyCommand extends Command{

	public BuyCommand() {
		super("buy", "b", "buy", "Buy supermisil");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {

		boolean buy = false;
		
		if(game.getPoints() >= 20) {
			game.buyMisil();
			buy =  true;
		}
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
