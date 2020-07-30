package commands;

import exceptions.*;
import logic.Game;

//import Logic.Game;

public class MoveCommand extends Command{
	
	
	private int numCasillas;
	private String direccion;
	
	public MoveCommand() {
		super("move", "m", "[m]ove <left|right><1|2>", "Moves UCM-Ship to the indicated direction");
		
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
	public boolean execute(Game game) throws CommandExecuteException{
		
		boolean move = false;
		
		/*
		 *  * las excepciones deberían lanzav-rse en el sitio del código donde ocurre el error
			  * es incorrecto indicar errores devolviendo un valor booleano para luego lanzar
			    una excepcion más arriba en la pila de llamadas al recibir el valor "false"
			    + p.ej. función boleana move de Game llamada por execute de MoveCommand
			     también es un sin sentido lanzar una excepción en un método y envolverla en otra EN EL MISMO MÉTODO
		 */
		if(this.direccion.equals("left")) {
			if(game.move((this.numCasillas * -1))) {
				move = true;
				game.update();
			}
		}
		else if (this.direccion.equals("right")){
			if(game.move(this.numCasillas)) {
				move = true;
				game.update();
			}
		}
		
		return move;
	}
	
	
	
	public Command parse(String[] commandWords) throws CommandParseException, NumberFormatException
	{
		Command command = null;
		int aux;
		
		//try {
			
			if (matchCommandName(commandWords[0])) {
				if(commandWords.length == 3) {
					if ((commandWords[1].equals("left")) || (commandWords[1].equals("right"))) {
						try {
							aux  = Integer.parseInt(commandWords[2]);
							
							if((Integer.parseInt(commandWords[2]) == 1) ||  (Integer.parseInt(commandWords[2]) == 2)) {
								command = new MoveCommand(commandWords[1], Integer.parseInt(commandWords[2]));
								
							}else throw new CommandParseException("only can move 1 or 2 cells");
							
							
						/* tratamiento de errores incompleto
						+ e.g. move left now, no recoge el NumberFormatException
						*/	
						}catch(NumberFormatException e ) {
							throw new  NumberFormatException("Cause of Exception: \n" +
								"\t NumberFormatException in parameter 2: \n" +
								"\t Format {move} {left | rigth} { 1 | 2 } ");
							
						}
						
					}else  throw new CommandParseException("Wrong direcction");
				}else throw new CommandParseException(incorrectNumArgsMsg);
			}
		/*}
		
		catch (CommandParseException  e ) {
			
			throw new CommandParseException(e.getMessage());
		}catch (NumberFormatException a) {
			throw new NumberFormatException("Error de parametro");
		}*/
		
		return command;
	}
}
