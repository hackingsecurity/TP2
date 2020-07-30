package commands;

import exceptions.*;
import logic.Game;

public class BuyCommand extends Command{

	public BuyCommand() {
		super("buy", "b", "[b]uy", "Buy supermisil for 20 point");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {

		boolean buy = false;
		
		/*
		 * 1 pedir a game que nos diga los puntos del jugador
		 * 2 si no hay punto suficientes lanzo excepción
		 * 3 si puedo pues compro un misil pero lo haga game
		 */
		/*
		  + e.g. función boleana buySuperMissile de Game llamada por execute de BuyCommand
		  * cuando se envuelve una excepción en otra se debe usar el constructor de Excepción de 2 parámetros
		    + en el primer parámetro se pasa un NUEVO mensaje (más alto nivel)
		    + en el segundo parámetro se pasa la excepción de bajo nivel (entera, no su mensaje)
		*/
		
		try {
			//if(game.buySuperMissile()) buy =  true;
			if(game.getPoints() >= game.getUCMShip().getCostSM()) {
				game.buySuperMissile();
				buy = true;
			}
			else throw new CommandExecuteException("You don't have enough points, so you can't buy a supermsil");
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
				/*
				 * - Command Pattern
					  * parse de comandos sin parámetros puede devolver "this" en vez de "new XXCommand"
					  + es lo que permite subir el método parse a una superclase "NoParamsCommand"
				 */
				if (commandWords.length == 1) command = this;
				else throw new CommandParseException (incorrectNumArgsMsg);	
			}
		}
		catch (CommandParseException e) {
			throw new CommandParseException(e.getMessage());
		}
		
		return command;
	}

}
