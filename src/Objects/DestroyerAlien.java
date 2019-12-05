//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;
import Logic.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip implements IExecuteRandomActions {

	private boolean lanzado;


	public DestroyerAlien(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live);
		this.lanzado = false;
	}



	
	public void computerAction() {
		// TODO Auto-generated method stub
		super.computerAction();	
		//la logica que nec
		if(IExecuteRandomActions.canGenerateRandomBomb(game)) {
			if(this.lanzado == false) {
				game.activarBomba(this.posX, this.posY);
				this.lanzado = true;
			}
		}
	}

	
	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		game.receivePoints(10);
		AlienShip.setContador();
	}



	
	public String toString(){
		 return "D[" + this.getLive()+ "]" ;
	}
}
