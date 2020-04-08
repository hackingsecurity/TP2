package object;

import logic.Game;

public class Bomb extends Weapon{
	
	//-----------------VARIABLES----------------
	
	private DestroyerAlien destroyer;
	
	
	//-----------------CONTRUCTOR---------------
	
	public Bomb(Game game, int posX, int posY, DestroyerAlien destroyer) {
		super(game, posX, posY, 1,1);
		
		this.destroyer = destroyer;
	}
	
	//--------------METHODS IMPLEMENTS IAttack-----------
	
	public boolean performAttack(GameObject other) {

		boolean performAttack = false;
		if(this.isAlive()) {
			if(other.isOnPosition(this.posX, this.posY)) {
				if(other.receiveBombAttack(damage)) {
					this.live = 0;
					performAttack = true;
				}
			}
		}
		return performAttack;
	}
	
	public boolean  receiveMissileAttack(int damage) {
		boolean hit = false;
		
		if(this.isAlive()) {	
			this.receiveDamageFromOtherObject(damage);
			hit = true;
		}	
		return hit;	
	}
	
	public boolean receiveSuperMissileAttack(int damage) {
		boolean hit = false;
		
		if(this.isAlive()) {	
			this.receiveDamageFromOtherObject(damage);
			this.destroyer.setBomb(false);
			hit = true;
		}	
		return hit;	
	}
	
	
	//--------------ABSTRACT METHODS------------
	
	@Override
	public void computerAction() {}
	
	public void onDelete() {
		if(!this.isAlive()) {
			this.destroyer.setBomb(false);
		}
	}
	
	public void move() {
		posX += 1;
		if(this.isOut()) {
			this.live = 0;
		}
	}
	
	
		//--------------OBJECT FORMAT OUTPUT-----------
	
	@Override
	public String toString(){
		
		 return ".";
	}
	
	@Override
	public String stringifed() {
		return "Bomb: "+  "B" + ";" + this.posX +"," +this.posY+"\n";  
	}
}
