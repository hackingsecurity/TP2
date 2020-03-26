//PAQUETE QUE LO CONTIENE
package commands;
import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;



public abstract class Command {
	
	
	protected final String name;
	protected final String shortcut;
	private final String details ;
	private final String help;
	
	
	protected static final String incorrectNumArgsMsg = "Incorrect number of arguments\n";
	protected static final String incorrectArgsMsg = "Incorrect argument format\n";
	

	
	public Command(String name, String shortcut, String details, String help){
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}
	

	
	public abstract boolean execute(Game game) throws CommandExecuteException;
	
	/**
	 * 1) Recibe un array de letras y palabras
	 * 2) Vemos de todos los comandos que tenemos si coincide con uno de ellos
	 * 3) Si conincide lo devolvemos a controller
	 * 4) sino, devolvemos null.
	 * 
	 * @param commandWords
	 * @return command if it is founded or null if it don´t exist
	 * @throws CommandParseException
	 */
	public abstract Command parse(String[] commandWords) throws CommandParseException;
	
	
	/**
	 * 	- equalsIgnoreCase -> Ignora mayusculas o minusculas.
	 * 
	*/
	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}
	
	public String helpText(){
		return details + " : " + help + "\n";
	}




}
