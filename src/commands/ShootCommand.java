package commands;

import exceptions.*;
import logic.Game;

/*
 * 
 * POR QUE USAMOS UPDATE EN EL EXECUTE!! QUE ALGUIEN ME LO EXPLIQUE
 */


public class ShootCommand extends Command{
	
	
	
	private boolean supermissile;
	
	
	
	public ShootCommand() {
		super("shoot", "s", "shoot", "UCM-Ship releases a misil or supermisil");
		this.supermissile = false;
	}
	public ShootCommand(Boolean sm) {
		super("shoot", "s", "shoot", "UCM-Ship releases a missil or supermissile");
		this.supermissile = sm;
	}
	
	
	/**
	 * Si no he disparado, disparo.
	 */
	public boolean execute(Game game) throws CommandExecuteException {
		
		boolean ex = false;
		
		try {
			if(this.supermissile) {
				if(game.shootSuperMissile()){
					game.enableSuperMissile();
					game.update();
					ex = true;
				
				}
				else throw new SuperMissileException();
			}
			else if(!game.shootMissile()) {
				game.enableMissile();
				game.update();
				ex = true;
				
			}
			else throw new MissileInFlightException ();
				
		}
		catch(MissileInFlightException | SuperMissileException e) {
			throw new CommandExecuteException(e.getMessage());
		}
		
		return ex;
	}

	
	public Command parse(String[] commandWords) throws CommandParseException {
		
		Command command = null;

		
		try {
			
			if (matchCommandName(commandWords[0])) {
				
				if(commandWords.length == 1) {
					command = new ShootCommand(false);
					
				}
				
				else if(commandWords.length == 2 ) {
					if ( (commandWords[1].equals("s")||(commandWords[1].equals("supermisil")))) {
						command = new ShootCommand(true);
					}
					else throw new CommandParseException ("Incorrect type of misil");
					
				}else throw new CommandParseException (incorrectNumArgsMsg);
					
			}
		}
		catch (CommandParseException e) {
			throw new CommandParseException(e.getMessage());
		}
		
		return command;
			
	}
}