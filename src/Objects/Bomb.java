//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;

public class Bomb extends Weapon{
	
	
	public Bomb(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live);
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
		
		
	}
	
	@Override
	public String toString(){
		
		 return ".";
	}
}
