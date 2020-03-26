package logic;

/**
 * 
 * Devuelve el nivel que hemos introducido al ejecutar nuestro programa.
 * 
 * Si no introducimos nada el nivel por defecto es facil.
 * 
 * Niveles dispoibles: 
 * 	-EASY
 * 	-HARD
 * 	-INSANE
 * 
 *
 */
public enum Level {

	/*
	NIVEL | NAVES COMUNES | NAVES DESTRUCTORAS | FREC. DISPARO | VELOCIDAD | OVNI | NUMBERS ROWS |
	 N			NC					ND				 FD				V		  O			NR
	 ---------------------------------------------------------------------------------------------
	 N  |NC|ND| FD | V | O | NR
	*/
	EASY(4, 2, 0.2, 3, 0.5, 1),
	HARD(8, 4, 0.3, 2, 0.2, 2),
	INSANE(12, 4, 0.5, 1, 0.1, 3);
	
	//-----------------VARIABLES----------------
	
	private int numRegularAliens;
	private int numDestroyerAliens;
	private double shootFrequency;
	private int numCyclesToMoveOneCell;
	private double ovniFrequency;
	private int numRowsOfRegularAliens;
	private double  turnExplodeFrequency = 0.10; // actualmente no depende del nivel
		
	//-----------------CONTRUCTOR---------------
	
	private Level(
		int numRegularAliens,
		int numDestroyerAliens,
		double shootFrequency,
		int numCyclesToMoveOneCell,  
		double ovniFrequency,
		int numRowsOfRegularAliens)
	{	
		this. numRegularAliens = numRegularAliens;
		this. numDestroyerAliens = numDestroyerAliens;
		this. shootFrequency = shootFrequency;
		this. numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this. ovniFrequency = ovniFrequency;
		this. numRowsOfRegularAliens = numRowsOfRegularAliens;
	}
	
	//--------------GETTER AND SETTER-----------
	
	
	public int getNumRegularAliens() { return numRegularAliens; }
	public int getNumDestroyerAliens() {return numDestroyerAliens;}
	public double getShootFrequency() {return shootFrequency;}
	public int getNumCyclesToMoveOneCell() {return numCyclesToMoveOneCell;}
	public double getOvniFrequency() {return ovniFrequency;}
	public int getNumRowsOfRegularAliens() {return numRowsOfRegularAliens;}
	public double getTurnExplodeFrequency() { return turnExplodeFrequency;}
	
	
	public int getNumRegularAliensPerRow() {return numRegularAliens / numRowsOfRegularAliens;}
	public int getNumDestroyerAliensPerRow() {	return getNumDestroyerAliens();}
	
	//--------------STATIC METHOD------------
	
	/**
	 * 1) cogemos todos los valores válidos de mi Enum
	 * 2) comparamos mi Enun con mi cadena 
	 * 3) ignoramos si esta en mayúsculas o minúsculas
	 * 
	 * @return 1) level si coincide nuestra cadena con el Enun
	 * @return 2) nivel facil si no coincide nuestra cadena con nuestro Enum o es vacio.
	 */
	public static Level parse(String cadenaEntrada) {
		for (Level level : Level.values())
			if (level.name().equalsIgnoreCase(cadenaEntrada)) return level;
			
		//Retorno por defecto el nivel fácil	
		return EASY;
		
	}
	
	
		

}
