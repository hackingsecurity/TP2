//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;
import Logic.IExecuteRandomActions;

public class RegularAlien extends AlienShip implements IExecuteRandomActions{

	public RegularAlien(Game game, int posX, int posY) {
		super(game, posX, posY, 2);
		// TODO Auto-generated constructor stub
	}

	public void computerAction() {
		// TODO Auto-generated method stub
		super.computerAction();	
		
		//la logica que nec
		if(IExecuteRandomActions.canGenerateExplodeShip(game)) {
			game.changeRegularToExplode(this.posX,this.posY,this.live);
		}
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
