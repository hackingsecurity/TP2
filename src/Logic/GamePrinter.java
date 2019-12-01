package Logic;


public class GamePrinter {	
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	
	public GamePrinter (Game game, int DIM_X, int DIM_Y) {
		this.numRows = DIM_X;
		this.numCols = DIM_Y;		
		encodeGame(game);
	}
	
	
	/*
	 * USAR INSTANCEOF PARA PODER COMPARAR OBJETOS DE UNA MISMA CLASE:
	 *	if(nameVariableClase instanceof  AlienShip)
	 *		-> devuelve un true si se cumple la condición
	 * SI  CUMPLE LA CONDICIÓN LLAMAMOS SU TOSTRING Y LO PINTAMOS EN EL TABLERO	
	 *
	 */
	private void encodeGame(Game game) {
		
		board = new String[numRows][numCols];
		
		
		int cont = 0;
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				
				
			/*	if (pos == 0) {
					board [i][j] = game.getDesList().getPos(i, j)
				}
				else {	
					board[i][j] =  space
				}
				*/
			}
		}
	}
	
	public String toString() {

		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;
		
		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);
		
		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;
		
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<numCols; j++)
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				if (i != numRows - 1) str.append(lineDelimiter);
				else str.append(lineEdge);	
		}
		
		return str.toString();
	}
}