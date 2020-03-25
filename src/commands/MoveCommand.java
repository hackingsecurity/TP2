package commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

//import Logic.Game;

public class MoveCommand extends Command{
	
	
	private int numCasillas;
	private String direccion;
	
	public MoveCommand() {
		super("move", "m", "move<left|right><1|2>", "Moves UCM-Ship to the indicated direction");
		
	}
	
	public MoveCommand(String direccion, int i) {
		super("move", "m", "move<left|right><1|2>", "Moves UCM-Ship to the indicated direction");
		this.numCasillas = i;
		this.direccion = direccion;
	}

	/*
	 * COMPROBAMOS SI ESTAMOS EN FUERA DEL TABLERO AL MOVER
	 * 
	 */
	public boolean execute(Game game) throws CommandExecuteException {
		
		boolean move = false;
		
		if(this.direccion.equals("left")) {
			if(game.move(this.numCasillas * -1)) {
				game.move(direccion, numCasillas);
				move = true;
			}
			else {
				
			}
		}
		else{
			if(game.move(this.numCasillas )) {
				game.move(direccion, numCasillas);
				move = true;
			}
		}
		
		game.update();
		if (move == false) {
			
			throw new CommandExecuteException("too near to the border");
		}
		
		return move;
	}
	
	
	
	public Command parse(String[] commandWords) throws CommandParseException
	{
		Command command = null;
		
		if (matchCommandName(commandWords[0])) {
			if(commandWords.length == 3) {
				if ((commandWords[1].equals("left")) || (commandWords[1].equals("right"))) {
					if((Integer.parseInt(commandWords[2]) == 1) ||  (Integer.parseInt(commandWords[2]) == 2)) {
						command = new MoveCommand(commandWords[1], Integer.parseInt(commandWords[2]));
						
					}else throw new CommandParseException("only can move 1 or 2 cells");
				}else  throw new CommandParseException("Wrong direcction");
			}else throw new CommandParseException(incorrectNumArgsMsg);
		}
		
		return command;
	}
}
