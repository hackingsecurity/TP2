package board;

import Logic.Game;

public class BoardPrinter extends GamePrinter {	
	
	private String[][] board;
	private final String space = " ";	
	private int numRows;
	private int numCols;
	
	public BoardPrinter (){
		
		this.numRows = Game.DIM_Y;
		this.numCols = Game.DIM_X;
		encodeGame(game);
	}
	
	
	private void encodeGame(Game game) {
			
			board = new String[this.numRows][this.numCols];
			String cad = "";
			
			for(int i = 0; i < this.numRows; i++) {
				for(int j = 0; j < this.numCols; j++) {
					
					cad = game.positionToString(i, j);
					if( cad != null) {
						board[i][j] = cad;
					}
					else {
						board[i][j] = space;
					}
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