//PAQUETE QUE LO CONTIENE
package commands;
import exceptions.CommandParseException;
import logic.Game;
import utils.CommandGenerator;


public class HelpCommand extends Command{

	
	public HelpCommand() {
		super("help", "h", "[h]elp", "Prints help message");
	}

	public boolean execute(Game game) {
		System.out.println(game.helpText());
		return false; //No ejecutamos otra pantalla
	}
	
	public Command parse(String[] commandWords) throws CommandParseException
	{
		Command command = null;
		
		if (matchCommandName(commandWords[0])) {
			/*
			 * - Command Pattern
				  * parse de comandos sin parámetros puede devolver "this" en vez de "new XXCommand"
				  + es lo que permite subir el método parse a una superclase "NoParamsCommand"
			 */
			if (commandWords.length == 1) command = this;
			else throw new CommandParseException (incorrectNumArgsMsg);	
		}
		
		return command;
	}
	
}
