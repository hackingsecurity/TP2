package board;

import logic.Game;
import utils.MyStringUtils;

public class BoardPrinter extends GamePrinter {	
	
	private String[][] boardPrinter;
	private final String space = " ";	
	private int numRows;
	private int numCols;
	
	
	
	public BoardPrinter (){
		
		super("boardPrinter");
		this.numRows = Game.DIM_Y;
		this.numCols = Game.DIM_X;
		
	}
	
	
	private void encodeGame(Game game) {
			
			boardPrinter = new String[this.numRows][this.numCols];
			String cad = "";
			
			for(int i = 0; i < this.numRows; i++) {
				for(int j = 0; j < this.numCols; j++) {
					
					cad = game.positionToString(i, j);
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
		
		return game.infoToString() + str.toString();
		}
	
	
	
	public GamePrinter parseBoard(String typeBoard){
			
		GamePrinter printer = null;
		
		if (typeBoard.equalsIgnoreCase("boardPrinter")) {
			printer = new BoardPrinter();
		}
	
		return printer;
	}

	
}