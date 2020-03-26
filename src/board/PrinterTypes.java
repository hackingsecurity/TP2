package board;
import logic.Game;


public enum PrinterTypes {
	
	BOARDPRINTER(
		"boardprinter",
		"prints the game formatted as a board of dimension: "
		),
		
	
	STRINGIFIER(
		"stringifier",
		"prints the game as plain text");
		
	
	
	private String printerName;
	private String helpText;
	
	
	private PrinterTypes(String name, String text) {
		printerName = name;
		helpText = text;
		
	}

	
	//Nos implementar la ayuda del comando 
	
	public static String printerHelp(Game game) {
		String helpString = "";
		
		/*
		 * -RECORREMOS NUESTRO ENUMERADO 
		 * -CARGAMOS EN NUESTRAS VARIABLES LOS DATOS DEL ENUM
		 * -OJO SU UN OPERADOR TERNARIO PARA DECIDIR SI ES UN ENUM U OTRO
		 */
		
		for (PrinterTypes printer : PrinterTypes.values())
		helpString += printer.printerName + ", " + printer.helpText + ", " +
		(printer == BOARDPRINTER ? Game.DIM_X + " x " + Game.DIM_Y : "") + "\n";
		
		return helpString;
	}
	
	
	/*public GamePrinter getObject(Game game) {
		
		printerObject.setGamePrinter(game);
		
		return printerObject;
	}
	*/
}
