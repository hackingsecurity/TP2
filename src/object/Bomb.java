//PAQUETE QUE LO CONTIENE
package object;

import Logic.Game;

public class Bomb extends Weapon{
	

	
	public Bomb(Game game, int posX, int posY, int id) {
		super(game, posX, posY, 1,1);
		this.id = id; 
		
	}


	public boolean performAttack(GameObject other) {
		boolean attack = false;
		
		if(posX + 1 == other.getPosX() && posY == other.getPosY() ) {
			attack = true;
			this.live -= 1;
			game.disableBomba(this.id);
		}
		
		return attack;
	}
	public boolean  receiveMissileAttack(int damage) {
		boolean hit=false;
		if(this.isAlive()) {
			this.live -= damage;
			game.disableBomba(this.id);
		}
		
		return hit;
	}
	
	public boolean receiveSuperMissileAttack(int damage) {
		boolean hit=false;
		if(this.isAlive()) {
			this.live -= damage;
			game.disableBomba(this.id);
		}
		
		return hit;
	}
	
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		if(posX == 7) {
			
			this.live -= 1;
			game.disableBomba(this.id);
		}
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
	public void move() {
		posX += 1;
	}
	
	public String stringifie() {
		return "B" + ";" + super.stringifed();  
	}
	
	@Override
	public String toString(){
		
		 return ".";
	}
}