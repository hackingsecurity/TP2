package board;
import logic.Game;


public enum PrinterTypes {
	
	/*
	 *  no has usado PrinterTypes para crear impresoras
	 *  LO hemos modificado para que podemoas crear impresoras.
	 */
	
	BOARDPRINTER(
		"boardprinter",
		"prints the game formatted as a board of dimension: ",
		new BoardPrinter()),
	STRINGIFIER(
		"stringifier",
		"prints the game as plain text",
		new Stringifier());
		
	private GamePrinter printerObject;
	private String printerName;
	private String helpText;
	
	
	private PrinterTypes(String name, String text, GamePrinter printerObject) {
		this.printerName = name;
		this.helpText = text;
		this.printerObject = printerObject;
		
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


	
	public GamePrinter getObject(Game game) {
		
		printerObject.setGame(game);
		
		return printerObject;
	}
	
}
