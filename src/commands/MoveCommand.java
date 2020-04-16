package commands;

import exceptions.*;
import logic.Game;

//import Logic.Game;

public class MoveCommand extends Command{
	
	
	private int numCasillas;
	private String direccion;
	
	public MoveCommand() {
		super("move", "m", "move<left|right><1|2>", "Moves UCM-Ship to the indicated direction");
		
	}
	
	public MoveCommand(String direccion, int numCasillas) {
		super("move", "m", "move<left|right><1|2>", "Moves UCM-Ship to the indicated direction");
		this.numCasillas = numCasillas;
		this.direccion = direccion;
	}

	/*public String listPrinterCommand() {
		return PrinterTypes.printerHelp(this);
	}

	
	 * COMPROBAMOS SI ESTAMOS EN FUERA DEL TABLERO AL MOVER
	 * 
	 */
	public boolean execute(Game game) throws CommandExecuteException {
		
		boolean move = false;
		try {
			if(this.direccion.equals("left")) {
				if(game.move((this.numCasillas * -1))) {
					move = true;
					game.update();
				}else throw new OffWorldException(); 
				
			}
			else if (this.direccion.equals("right")){
				if(game.move(this.numCasillas)) {
					move = true;
					game.update();
				}else throw new OffWorldException(); 
			}
			 
		}catch(OffWorldException e) {
			throw new CommandExecuteException(e.getMessage());
		}
		return move;
	}
	
	
	
	public Command parse(String[] commandWords) throws CommandParseException
	{
		Command command = null;
		
		try {
			
			if (matchCommandName(commandWords[0])) {
				if(commandWords.length == 3) {
					if ((commandWords[1].equals("left")) || (commandWords[1].equals("right"))) {
						if((Integer.parseInt(commandWords[2]) == 1) ||  (Integer.parseInt(commandWords[2]) == 2)) {
							command = new MoveCommand(commandWords[1], Integer.parseInt(commandWords[2]));
							
						}else throw new CommandParseException("only can move 1 or 2 cells");
					}else  throw new CommandParseException("Wrong direcction");
				}else throw new CommandParseException(incorrectNumArgsMsg);
			}
		}
		catch (CommandParseException e) {
			throw new CommandParseException(e.getMessage());
		}
		
		return command;
	}
}
