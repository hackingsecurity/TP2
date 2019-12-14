package object;
import Logic.Game;


public class ExplodeShip extends AlienShip {
	
	public  ExplodeShip(Game game,int posX,int posY, int vida){
		super(game, posX,  posY, vida);
		AlienShip.setContador();
	}
	
	
	
	
	
	
	public boolean receiveMissileAttack(int damage) {
		boolean hit = false;
		if(this.isAlive() && this.live == 1) {
			game.explode(this.posX,this.posY,damage);
			this.live--;
			hit = true;
		}
			return hit;
		};
	public boolean receiveSuperMissileAttack(int damage) {
			boolean hit= false;
			if(this.isAlive()) {
				game.explode(this.posX,this.posY,damage);
				this.live -= damage;
				hit = true;
			}
			return hit;
		}
	
	
	public String stringifie() {
		return "E" + ";" + super.stringifed() + ";" 
				+ this.live + ";" + AlienShip.getSentido() ;   
	}
	
	
	public String toString(){
		 return "E[" + this.getLive()+ "]" ;
	}




	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		if(!this.isAlive()) {
			game.receivePoints(5);
			AlienShip.setContador();
		}
	}
}
