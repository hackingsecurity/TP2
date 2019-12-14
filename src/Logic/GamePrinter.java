package Logic;

public abstract class GamePrinter {
	
	protected int numRows;
	protected int numCols;
	protected Game game;
	String[][] board;
	final String space = " ";
	
	public GamePrinter(Game game) {
		
		this.numRows = Game.DIM_X;
		this.numCols = Game.DIM_Y;
		this.game = game;
		
	}
	protected void encodeGame(Game game) {
		
		board = new String[numRows][numCols];
		String cad = "";
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				
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
	
	public abstract String  toString();
}
