//PAQUETE QUE LO CONTIENE
package Control;
//PAQUETE QUE NECESITA PARA OPERAR
import Logic.Game;



public abstract class Command {
	
	
	
	/* [PAGINA 3 ENUNCIADO P2]
	 * Con la aplicación del patrón command, para saber qué comando
		ejecutar, el método run del controlador divide en palabras el texto proporcionado por el
		usuario (input) a través de la consola, para a continuación invocar un método de la clase
		utilidad 3 CommandGenerator, al que se le pasa el input como parámetro. Este método le
		pasa, a su vez, el input a un objeto comando de cada una de las clases concretas (que,
		como decimos, son subclases de Command) para averiguar cuál de ellos lo acepta como
		correcto. De esta forma, cada subclase de Command busca en el input el texto del comando
		que la subclase representa
		
		Aquel objeto comando que acepte el input como correcto devuelve al CommandGe-
		nerator otro objeto comando de la misma clase que él. El parseador pasará, a su vez, el
		objeto comando recibido al controlador. Los objetos comando para los cuales el input no
		es correcto devuelven el valor null. Si ninguna de las subclases concretas de comando acep-
		ta el input como correcto, es decir, si todas ellas devuelven null, el controlador informa
		al usuario de que el texto introducido no corresponde a ningún comando conocido. De
		esta forma, si el texto proporcionado por el usuario corresponde a un comando del siste-
		ma, el controlador obtiene del parseador CommandGenerator un objeto de la subclase que
		representa a ese comando y que puede, a su vez, ejecutar el comando.
			 
	 * 
	 * 
	 * 	[PAGINA 4 ENUNCIADO P2]
	 	De los métodos abstractos anteriores, execute se implementa invocando algún método
		con el objeto game pasado como parámetro y ejecutando alguna acción más. El método
		parse se implementa con un método que parsea el texto de su primer argumento (que es
		el texto proporcionado por el usuario por consola, dividido en palabras) y devuelve:
		o bien un objeto de una subclase de Command, si el texto que ha dado lugar al primer
		rgumento se corresponde con el texto asociado a esa subclase,
		o el valor null, en otro caso.
		
	 */
	
	protected final String name;
	protected final String shortcut;
	private final String details ;
	private final String help;
	
	protected static final String incorrectNumArgsMsg = "Incorrect number of arguments";
	protected static final String incorrectArgsMsg = "Incorrect argument format";
	
	
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
	
	public abstract boolean execute(Game game);
	
	public abstract Command parse(String[] commandWords);
	
	
	/*equealsIgnoreCase		-> eJ this.shortcut ( se supone que m)
	*						-> Ej this.name ( se supone que move)
	*
	*		->Ignora mayus y minusculas
	*
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
