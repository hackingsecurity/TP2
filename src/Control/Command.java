//PAQUETE QUE LO CONTIENE
package Control;
import Exeptions.CommandExecuteException;
import Exeptions.CommandParseException;

//PAQUETE QUE NECESITA PARA OPERAR
import Logic.Game;



public abstract class Command {
	
	
	protected final String name;
	protected final String shortcut;
	private final String details ;
	private final String help;
	
	
	protected static final String incorrectNumArgsMsg = "Incorrect number of arguments\n";
	protected static final String incorrectArgsMsg = "Incorrect argument format\n";
	
	
	/*
	 * Name 		->  comandos
	 * shortcut 	-> Abreviatura
	 * Details		->
	 * help			
	 */
	
	public Command(String name, String shortcut, String details, String help){
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}
	
	
	//METODOS ABSTRACTOS
		//se van a implementar en las clases derivadas o hijas
	
	public abstract boolean execute(Game game) throws CommandExecuteException;
	
	public abstract Command parse(String[] commandWords) throws CommandParseException;
	
	
	/*
	 * 	- equelasIgnoreCase -> Ignora mayusculas o minusculas.
	*/
	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) ||
		this.name.equalsIgnoreCase(name);
	}
	
	//METODO PUBLICO TEXTO DE AYUDA
	public String helpText(){
		return details + " : " + help + "\n";
	}
	

}
