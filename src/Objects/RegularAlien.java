//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;

public class RegularAlien extends AlienShip {

	public RegularAlien(Game game, int posX, int posY) {
		super(game, posX, posY, 2);
		// TODO Auto-generated constructor stub
	}

	
	

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		if(!this.isAlive()) {
			game.receivePoints(5);
			AlienShip.setContador();
		}
	}


	@Override
	public String toString() {
		return "R[" + this.live + "]";
	}

}
