//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;

public class Shockwave extends Weapon{
	

	
	public Shockwave(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live,1);

	
	
	}
	
	
	public boolean performAttack(GameObject other) {
		this.live -= 1;
		game.disableSW();
		return true;
		
	}
	

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}
    

	@Override
	public String toString() {
		return null;
	}


	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	

}
