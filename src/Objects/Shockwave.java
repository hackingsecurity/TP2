//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;

public class Shockwave extends Weapon{
	

	
	public Shockwave(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live);

	
	
	}
	
	
	public boolean performAttack(GameObject other) {
		this.live--;
		game.disableSW();
		return true;
		
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
		return null;
	}

	

}
