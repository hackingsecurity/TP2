package board;

import logic.Game;
import object.AlienShip;
import utils.MyStringUtils;

public class BoardPrinter extends GamePrinter {	
	
	private String[][] boardPrinter;
	private final String space = " ";	
	private int numRows;
	private int numCols;
	
	
	
	public BoardPrinter (Game game){
		
		super(game);
		this.numRows = Game.DIM_X;
		this.numCols = Game.DIM_Y;
		
	}
	
	
	private void encodeGame(Game game) {
			
			boardPrinter = new String[this.numRows][this.numCols];
			String cad = "";
			
			for(int i = 0; i < this.numRows; i++) {
				for(int j = 0; j < this.numCols; j++) {
					
					cad = game.toString(i, j);
					if( cad != null) {
						boardPrinter[i][j] = cad;
					}
					else {
						boardPrinter[i][j] = space;
					}
				}
			}
	}
		
	public String toString() {
		
		encodeGame(this.game);

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
					str.append( MyStringUtils.centre(boardPrinter[i][j], cellSize)).append(vDelimiter);
				if (i != numRows - 1) str.append(lineDelimiter);
				else str.append(lineEdge);	
		}
		
		return infoToString(game) + str.toString();
		}
	
	
	
	
	//CABECERA DEL JUEGO
	private String infoToString(Game game) {
		

		return "Life: " + game.getUCMShip().getLive() +
				"\nNumber of cycles: " + game.getCurrentCycle() +
				"\nPoint: " + game.getPoints() +
				"\nRemaining aliens: " + AlienShip.getContadorAlien() +
				"\nSuperMissiles: " + game.getUCMShip().getNumSuperMissiles() +
				"\nShockWave: " + game.getUCMShip().getShockWave() + "\n";
	}
	
	/*public GamePrinter parseBoard(String typeBoard){
			
		GamePrinter printer = null;
		
		if (typeBoard.equalsIgnoreCase("boardPrinter")) {
			printer = new BoardPrinter();
		}
	
		return printer;
	}
*/
	
}