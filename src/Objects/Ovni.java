package Objects;

import Logic.Game;

public class Ovni extends AlienShip {

	public Ovni() {
		super();
	}

	public Ovni(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "O[" + this.live + "]" ;
	}
}
