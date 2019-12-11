//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;

public class UCMMissile extends Weapon{
	

	public UCMMissile(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		if(this.posX == 0) {
			game.disableMissile();
		}
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}								//destroyer 1
	public boolean performAttack(GameObject other) {
		boolean attack = false;
		
		if((posX - 1 == other.getPosX() && posY == other.getPosY()) ) {
			attack = true;
			this.live -= 1;
			game.disableMissile();
		}
		
		return attack;
	}
	
	public void move() {
		posX -= 1; 
	}
	
	@Override
	public String toString() {
		return "oo";
	}
}
