package commands;

import exceptions.*;
import logic.Game;

/*
 * 
 * POR QUE USAMOS UPDATE EN EL EXECUTE!! QUE ALGUIEN ME LO EXPLIQUE
 */


public class ShootCommand extends Command{
	
	
	String tipo;
	
	
	public ShootCommand() {
		super("shoot", "s", "shoot", "UCM-Ship releases a shock wave");
	}
	
	
	public ShootCommand(String tipo) {
		
		super("shoot", "s", "shoot", "UCM-Ship releases a shock wave");
		this.tipo = tipo;
	}

	public boolean execute(Game game) throws CommandExecuteException {
		
		boolean ex = false;
		
		if(game.shootMissile()){
			
			if(this.tipo.equals("m")) 
			{
					game.enableMissile();
					game.update();
			
			}
			else if(game.getSuperMisil() > 0) {
					game.enableSuperMissile();
					game.update();
					
			}
			else {
				throw new CommandExecuteException("You don't have superMissile");
				
			}
			ex = true;
			
		}else throw new CommandExecuteException ("ya hay misil en partida");
	
		return ex;	
	}

	
	public Command parse(String[] commandWords) throws CommandParseException {
		
		Command command = null;

		if (matchCommandName(commandWords[0])) {
			if(commandWords.length == 2 ) {
				if ((commandWords[1].equals("m")) || (commandWords[1].equals("s"))) {
					command = new ShootCommand(commandWords[1]);
				}
				else throw new CommandParseException ("Incorrect type of misil");
				
			}else throw new CommandParseException (incorrectNumArgsMsg);
				
		}
			return command;
	}
		
}
