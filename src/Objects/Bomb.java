//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;
import Logic.IExecuteRandomActions;

public class Bomb extends Weapon{
	

	
	public Bomb(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live);
	}


	public boolean performAttack(GameObject other) {
		boolean attack = false;
		
		if(posX + 1 == other.getPosX() && posY == other.getPosY() ) {
			attack = true;
		}
		
		return attack;
	}
	public boolean  receiveMissileAttack(int damage) {
		boolean hit=false;
		if(this.isAlive()) {
			this.live -= damage;
		}
		
		return hit;
	}
	

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		if(posX == 7) {
			
			this.live -= 1;
		}
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
	public void move() {
		posX += 1;
	}
	
	
	
	@Override
	public String toString(){
		
		 return ".";
	}
}
